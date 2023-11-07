package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class UserRepositoryTest {

    UserRepository repository;
    User user;

    @BeforeEach
    void setup() {
        repository = new UserRepository();
        user = new User("1","1", false);
    }

    @Test
    void addAuthorizedUserToRepository() {
        user.authenticate("1","1");
        repository.addUser(user);
        assertTrue(repository.data.contains(user));
    }
    @Test
    void addNotAuthorizedUserToRepository() {
        user.authenticate("1","4");
        repository.addUser(user);
        assertFalse(repository.data.contains(user));
    }

    @Test
    void logOutEveryoneExceptAdministrators() {
        User admin = new User("roma","123", true);
        admin.authenticate("roma","123");
        repository.addUser(admin);
        user.authenticate("1","1");
        repository.addUser(user);
        repository.logOutNonPrivilegedUsers();
        for (User loggedUser:repository.data) {
            if (!user.isAdmin) {
                assertFalse(user.isAuthenticate);
            } else {
                assertTrue(user.isAuthenticate);
            }
        }
    }

}