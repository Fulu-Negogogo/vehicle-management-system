package za.co.protogen.utility;

import za.co.protogen.domain.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Constant {
    public static List<User> users = new ArrayList<>();

    static {
        User user1 = new User(1L, "John", "Doe", LocalDate.of(1990, 1, 1), "1234567890123");
        User user2 = new User(2L, "Jane", "Smith", LocalDate.of(1985, 6, 15), "9876543210987");
        users.add(user1);
        users.add(user2);
    }
}
