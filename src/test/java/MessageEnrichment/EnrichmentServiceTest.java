package MessageEnrichment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class EnrichmentServiceTest {

    private EnrichmentService enrichmentService;

    @BeforeEach
    void setUp() {
        UserRepository userRepository = new UserRepository();
        userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));
        enrichmentService = new EnrichmentService(userRepository);
    }

    @Test
    void shouldEnrichMessageWithMsisdnType() {
        Map<String, String> content = new HashMap<>();
        content.put("msisdn", "88005553535");
        Message message = new Message(content, EnrichmentType.MSISDN);
        Message enrichedMessage = enrichmentService.enrich(message);
        assertEquals("Vasya", enrichedMessage.getContent().get("firstName"));
        assertEquals("Ivanov", enrichedMessage.getContent().get("lastName"));
    }

    @Test
    void shouldReturnSameMessageWhenStrategyNotFound() {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        Message message = new Message(content, null);
        Message result = enrichmentService.enrich(message);
        assertEquals(content, result.getContent());
    }
}