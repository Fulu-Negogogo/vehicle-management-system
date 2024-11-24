package za.co.protogen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.User;
import za.co.protogen.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        return ResponseEntity.status(201).body(createdUser); // Return 201 Created
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build(); // Return 404 if user not found
        }
        userService.removeUser(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build(); // Return 404 if user not found
        }
        return ResponseEntity.ok(user); // Return 200 OK
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users); // Return 200 OK
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser == null) {
            return ResponseEntity.notFound().build(); // Return 404 if user not found
        }
        return ResponseEntity.ok(updatedUser); // Return 200 OK
    }
}
