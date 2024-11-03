package enrichments.strategy;

import enrichments.domain.ContentKeys;
import enrichments.repository.UserRepositoryInterface;
import enrichments.domain.User;

import java.util.Map;

public class MSISDNStrategy implements EnrichmentStrategy {
    private final UserRepositoryInterface userRepository;

    public MSISDNStrategy(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, String> enrich(Map<String, String> content) {
        String msisdn = content.get(ContentKeys.MSISDN);
        if (msisdn == null) return content;

        User user = userRepository.findByMsisdn(msisdn);
        if (user != null) {
            content.put(ContentKeys.FIRST_NAME, user.firstName());
            content.put(ContentKeys.LAST_NAME, user.lastName());
        }
        return content;
    }
}