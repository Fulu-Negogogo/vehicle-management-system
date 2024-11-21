package za.co.protogen.core.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Constant constant;

    @Override
    public User addUser(User user) {
        constant.getUsers().add(user);
        return user;
    }

    @Override
    public void removeUser(Long id) {
        constant.getUsers().removeIf(user -> user.getId().equals(id));
    }

    @Override
    public User getUserById(Long id) {
        return constant.getUsers().stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return constant.getUsers();
    }

    @Override
    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
        }
        return existingUser;
    }
}
