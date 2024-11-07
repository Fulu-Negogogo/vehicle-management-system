package za.co.protogen;

import za.co.protogen.core.UserService;
import za.co.protogen.core.impl.UserServiceImpl;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        // Here, you can invoke various methods of userService to test functionality.
    }
}
