package za.co.protogen.core;

import za.co.protogen.domain.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    void removeUser(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);
}
