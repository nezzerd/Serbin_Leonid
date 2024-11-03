package enrichments;

import enrichments.repository.UserRepository;
import enrichments.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserRepositoryTest {

    @Test
    @DisplayName("Should return user when MSISDN exists")
    void shouldReturnUserWhenMsisdnExists() {
        UserRepository userRepository = new UserRepository();
        userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));
        User user = userRepository.findByMsisdn("88005553535");
        assertNotNull(user);
        assertEquals("Vasya", user.firstName());
        assertEquals("Ivanov", user.lastName());
    }

    @Test
    @DisplayName("Should return null when MSISDN does not exist")
    void shouldReturnNullWhenMsisdnDoesNotExist() {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findByMsisdn("nonexistent_msisdn");
        assertNull(user);
    }

    @Test
    @DisplayName("Should update user successfully")
    void shouldUpdateUserSuccessfully() {
        UserRepository userRepository = new UserRepository();
        userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));
        userRepository.updateUserByMsisdn("88005553535", new User("Petya", "Petrov"));
        User updatedUser = userRepository.findByMsisdn("88005553535");
        assertNotNull(updatedUser);
        assertEquals("Petya", updatedUser.firstName());
        assertEquals("Petrov", updatedUser.lastName());
    }
}