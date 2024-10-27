package MessageEnrichment;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class UserRepository implements UserRepositoryInterface {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public User findByMsisdn(String msisdn) {
        return users.get(msisdn);
    }

    @Override
    public void updateUserByMsisdn(String msisdn, User user) {
        users.put(msisdn, user);
    }
}