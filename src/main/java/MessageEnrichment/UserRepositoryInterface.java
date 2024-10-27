package MessageEnrichment;

public interface UserRepositoryInterface {
    User findByMsisdn(String msisdn);
    void updateUserByMsisdn(String msisdn, User user);
}