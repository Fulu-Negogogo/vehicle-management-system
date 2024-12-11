package za.co.protogen.utility;

import org.springframework.stereotype.Component;
import za.co.protogen.domain.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class Constant {
    private final List<User> users = new ArrayList<>();

    public Constant() {
        // Initialize with some default users
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("john.doe");
        user1.setEmail("john.doe@example.com");
        user1.setFirstName("John");
        user1.setLastName("Doe");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("jane.smith");
        user2.setEmail("jane.smith@example.com");
        user2.setFirstName("Jane");
        user2.setLastName("Smith");

        users.add(user1);
        users.add(user2);
    }

    // Provide direct access to users list for modification inside this class
    public List<User> getUsers() {
        return users;  // Users list is mutable inside the class
    }
}
