package za.co.protogen.reservationsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.protogen.reservationsservice.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Additional query methods can be defined here if needed
}
