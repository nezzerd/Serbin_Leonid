package MessageEnrichment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void shouldReturnUserWhenMsisdnExists() {
        UserRepository userRepository = new UserRepository();
        userRepository.updateUserByMsisdn("88005553535", new User("Vasya", "Ivanov"));
        User user = userRepository.findByMsisdn("88005553535");
        assertNotNull(user);
        assertEquals("Vasya", user.firstName());
        assertEquals("Ivanov", user.lastName());
    }

    @Test
    void shouldReturnNullWhenMsisdnDoesNotExist() {
        UserRepository userRepository = new UserRepository();
        User user = userRepository.findByMsisdn("nonexistent_msisdn");
        assertNull(user);
    }

    @Test
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