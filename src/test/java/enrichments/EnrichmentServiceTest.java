package enrichments;

import enrichments.domain.Message;
import enrichments.domain.ContentKeys;
import enrichments.domain.EnrichmentType;
import enrichments.domain.User;
import enrichments.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class EnrichmentServiceTest {

    private EnrichmentService enrichmentService;

    @BeforeEach
    void setUp() {
        UserRepository userRepository = new UserRepository();
        userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));
        enrichmentService = new EnrichmentService(userRepository);
    }

    @Test
    @DisplayName("Should enrich message with MSISDN type")
    void shouldEnrichMessageWithMsisdnType() {
        Map<String, String> content = new HashMap<>();
        content.put(ContentKeys.MSISDN, "88005553535");
        Message message = new Message(content, EnrichmentType.MSISDN);
        Message enrichedMessage = enrichmentService.enrich(message);
        assertEquals("Vasya", enrichedMessage.getContent().get(ContentKeys.FIRST_NAME));
        assertEquals("Ivanov", enrichedMessage.getContent().get(ContentKeys.LAST_NAME));
    }

    @Test
    @DisplayName("Should return same message when strategy is not found")
    void shouldReturnSameMessageWhenStrategyNotFound() {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        Message message = new Message(content, null);
        Message result = enrichmentService.enrich(message);
        assertEquals(content, result.getContent());
    }

    @Test
    @DisplayName("Should handle null message gracefully")
    void shouldHandleNullMessageGracefully() {
        Message result = enrichmentService.enrich(null);
        assertNull(result);
    }
}