package MessageEnrichment;

import java.util.Map;

public class Message {
    private Map<String, String> content;
    private final EnrichmentType enrichmentType;

    public Message(Map<String, String> content, EnrichmentType enrichmentType) {
        this.content = content;
        this.enrichmentType = enrichmentType;
    }

    public EnrichmentType getEnrichmentType() {
        return enrichmentType;
    }

    public Map<String, String> getContent() {
        return content;
    }

    public void setContent(Map<String, String> content) {
        this.content = content;
    }
}