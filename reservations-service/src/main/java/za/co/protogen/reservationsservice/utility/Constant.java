package za.co.protogen.reservationsservice.utility;

import org.springframework.stereotype.Component;
import za.co.protogen.reservationsservice.domain.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Constant {

    private static final List<Reservation> reservations = new ArrayList<>();

    static {
        reservations.add(new Reservation(1L, 1L, 101L, LocalDate.of(2024, 11, 21), LocalDate.of(2024, 11, 25), "New York", "Los Angeles"));
        reservations.add(new Reservation(2L, 2L, 102L, LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 5), "London", "Paris"));
    }

    public static List<Reservation> getReservations() {
        return reservations;
    }
}
