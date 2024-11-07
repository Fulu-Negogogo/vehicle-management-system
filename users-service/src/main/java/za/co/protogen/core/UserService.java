package za.co.protogen.core;

import za.co.protogen.domain.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
    void updateUser(User user);
    List<User> searchUsers(String firstName, String lastName, LocalDate dateOfBirth);
}
