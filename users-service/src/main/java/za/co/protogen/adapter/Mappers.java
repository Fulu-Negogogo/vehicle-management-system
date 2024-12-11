package za.co.protogen.adapter;

import org.springframework.stereotype.Component;
import za.co.protogen.domain.User;

@Component
public class Mappers {

    // Method to map to User object, assuming it takes necessary fields to create a new User
    public User mapToUser(Long id, String username, String email, String firstName, String lastName) {
        User user = new User(); // Create a new User object
        user.setId(id); // Set the ID (Long type)
        user.setUsername(username); // Set the username
        user.setEmail(email); // Set the email
        user.setFirstName(firstName); // Set the first name
        user.setLastName(lastName); // Set the last name
        return user;
    }

    // Method to update an existing User object with new values
    public User updateUser(User existingUser, String username, String email, String firstName, String lastName) {
        existingUser.setUsername(username);  // Update username
        existingUser.setEmail(email);  // Update email
        existingUser.setFirstName(firstName);  // Update first name
        existingUser.setLastName(lastName);  // Update last name
        return existingUser;  // Return the updated user
    }
}
