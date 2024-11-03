package enrichments.repository;

import enrichments.domain.User;

public interface UserRepositoryInterface {
    User findByMsisdn(String msisdn);
    void updateUserByMsisdn(String msisdn, User user);
}