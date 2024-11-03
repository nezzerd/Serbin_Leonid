package enrichments;

import enrichments.domain.Message;
import enrichments.strategy.EnrichmentStrategy;
import enrichments.domain.EnrichmentType;
import enrichments.repository.UserRepositoryInterface;
import enrichments.strategy.MSISDNStrategy;

import java.util.HashMap;
import java.util.Map;

public class EnrichmentService {
    private final Map<EnrichmentType, EnrichmentStrategy> strategies = new HashMap<>();

    public EnrichmentService(UserRepositoryInterface userRepository) {
        strategies.put(EnrichmentType.MSISDN, new MSISDNStrategy(userRepository));
    }

    public Message enrich(Message message) {
        if (message == null) {
            return null;
        }
        EnrichmentStrategy strategy = strategies.get(message.getEnrichmentType());
        if (strategy != null) {
            Map<String, String> enrichedContent = strategy.enrich(message.getContent());
            message.setContent(enrichedContent);
        }
        return message;
    }
}