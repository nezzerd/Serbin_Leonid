package MessageEnrichment;

import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @Test
    void shouldSucceedEnrichmentInConcurrentEnvironmentSuccessfully() throws InterruptedException {
        UserRepository userRepository = new UserRepository();
        userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));

        EnrichmentService enrichmentService = new EnrichmentService(userRepository);
        List<Message> enrichmentResults = new CopyOnWriteArrayList<>();

        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        content.put("page", "book_card");
        content.put(ContentKeys.MSISDN, "88005553535");
        Message message = new Message(content, EnrichmentType.MSISDN);

        int numberOfThreads = 5;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                enrichmentResults.add(enrichmentService.enrich(message));
                latch.countDown();
            });
        }

        latch.await();
        executorService.shutdown();

        for (Message enrichedMessage : enrichmentResults) {
            assertEquals("Vasya", enrichedMessage.getContent().get(ContentKeys.FIRST_NAME));
            assertEquals("Ivanov", enrichedMessage.getContent().get(ContentKeys.LAST_NAME));
        }

        assertEquals(numberOfThreads, enrichmentResults.size());
    }
}