package za.co.protogen.core.impl;

import za.co.protogen.core.UserService;
import za.co.protogen.domain.User;
import za.co.protogen.utility.Constant;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser(User user) {
        Constant.users.add(user);
    }

    @Override
    public void removeUser(Long userId) {
        Constant.users.removeIf(user -> user.getId().equals(userId));
    }

    @Override
    public User getUserById(Long userId) {
        return Constant.users.stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return Constant.users;
    }

    @Override
    public void updateUser(User updatedUser) {
        for (int i = 0; i < Constant.users.size(); i++) {
            if (Constant.users.get(i).getId().equals(updatedUser.getId())) {
                Constant.users.set(i, updatedUser);
                break;
            }
        }
    }

    @Override
    public List<User> searchUsers(String firstName, String lastName, LocalDate dateOfBirth) {
        return Constant.users.stream()
                .filter(user -> (firstName == null || user.getFirstName().equalsIgnoreCase(firstName)) &&
                        (lastName == null || user.getLastName().equalsIgnoreCase(lastName)) &&
                        (dateOfBirth == null || user.getDateOfBirth().equals(dateOfBirth)))
                .collect(Collectors.toList());
    }
}
