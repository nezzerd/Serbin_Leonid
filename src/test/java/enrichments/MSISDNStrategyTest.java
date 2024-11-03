package enrichments;

import enrichments.domain.User;
import enrichments.repository.UserRepository;
import enrichments.strategy.MSISDNStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class MSISDNStrategyTest {

    private MSISDNStrategy msisdnStrategy;

    @BeforeEach
    void setUp() {
        UserRepository userRepository = new UserRepository();
        userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));
        msisdnStrategy = new MSISDNStrategy(userRepository);
    }

    @Test
    @DisplayName("Should enrich message when user exists")
    void shouldEnrichMessageWhenUserExists() {
        Map<String, String> content = new HashMap<>();
        content.put("msisdn", "88005553535");
        Map<String, String> enrichedContent = msisdnStrategy.enrich(content);
        assertEquals("Vasya", enrichedContent.get("firstName"));
        assertEquals("Ivanov", enrichedContent.get("lastName"));
    }

    @Test
    @DisplayName("Should not enrich when MSISDN is absent")
    void shouldNotEnrichWhenMsisdnIsAbsent() {
        Map<String, String> content = new HashMap<>();
        content.put("action", "button_click");
        Map<String, String> enrichedContent = msisdnStrategy.enrich(content);
        assertFalse(enrichedContent.containsKey("firstName"));
        assertFalse(enrichedContent.containsKey("lastName"));
    }

    @Test
    @DisplayName("Should not enrich when user does not exist")
    void shouldNotEnrichWhenUserDoesNotExist() {
        Map<String, String> content = new HashMap<>();
        content.put("msisdn", "nonexistent_msisdn");
        Map<String, String> enrichedContent = msisdnStrategy.enrich(content);
        assertFalse(enrichedContent.containsKey("firstName"));
        assertFalse(enrichedContent.containsKey("lastName"));
    }
}