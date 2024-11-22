package za.co.protogen.reservationsservice.utility;

import za.co.protogen.reservationsservice.domain.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Constant {
    private static final List<Reservation> reservations = new ArrayList<>();

    static {
        Reservation reservation1 = new Reservation(1L, "John Doe", "Toyota Corolla", LocalDate.of(2024, 11, 21));
        Reservation reservation2 = new Reservation(2L, "Jane Smith", "Honda Civic", LocalDate.of(2024, 11, 22));

        reservations.add(reservation1);
        reservations.add(reservation2);
    }

    public static List<Reservation> getReservations() {
        return reservations;
    }
}
