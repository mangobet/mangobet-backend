package org.ignisus.mangobetbackend.classes;

    
import org.ignisus.mangobetbackend.enums.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class UserTest {
    @Test
    void testUserConstructors() {
        User user = new User("1", "test", "test", "test", UserRole.ADMIN);
        assert(user.getId().equals("1"));
        assert(user.getUsername().equals("test"));
        assert(user.getPassword().equals("test"));
        assert(user.getEmail().equals("test"));
        assert(user.getRole().equals(UserRole.ADMIN));

        User user2 = new User("test", "test", "test");
        assert(user2.getId() == null); // No ID
        assert(user2.getUsername().equals("test"));
        assert(user2.getPassword().equals("test"));
        assert(user2.getEmail().equals("test"));

        User user3 = new User();    // Empty constructor
        assert(user3.getId() == null);
        assert(user3.getUsername() == null);
        assert(user3.getPassword() == null);
        assert(user3.getEmail() == null);
        assert(user3.getRole() == null);
    }
    @Test
    void testUserRoleTypes() {
        assert(UserRole.ADMIN.toString().equals("ADMIN"));
        assert(UserRole.NORMAL.toString().equals("NORMAL"));
        assert(UserRole.OWNER.toString().equals("OWNER"));
    }

    void testUserSetter(){
        User user = new User();
        user.setEmail("test");
        user.setId("test");
        user.setPassword("test");
        user.setRole(UserRole.ADMIN);
        user.setUsername("test");
        assert(user.getId().equals("test"));
        assert(user.getUsername().equals("test"));
        assert(user.getPassword().equals("test"));
        assert(user.getEmail().equals("test"));
        assert(user.getRole().equals(UserRole.ADMIN));
    }


}