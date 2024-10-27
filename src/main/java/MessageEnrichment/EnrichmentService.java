package MessageEnrichment;

import java.util.HashMap;
import java.util.Map;

public class EnrichmentService {
    private final Map<EnrichmentType, EnrichmentStrategy> strategies = new HashMap<>();

    public EnrichmentService(UserRepositoryInterface userRepository) {
        strategies.put(EnrichmentType.MSISDN, new MSISDNStrategy(userRepository));
    }

    public Message enrich(Message message) {
        EnrichmentStrategy strategy = strategies.get(message.getEnrichmentType());
        if (strategy != null) {
            Map<String, String> enrichedContent = strategy.enrich(message.getContent());
            message.setContent(enrichedContent);
        }
        return message;
    }
}