package enrichments.strategy;

import java.util.Map;

public interface EnrichmentStrategy {
    Map<String, String> enrich(Map<String, String> content);
}