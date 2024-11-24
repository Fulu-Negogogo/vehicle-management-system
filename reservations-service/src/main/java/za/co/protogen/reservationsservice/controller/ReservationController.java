package za.co.protogen.reservationsservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.protogen.reservationsservice.domain.Reservation;
import za.co.protogen.reservationsservice.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(reservation);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.addReservation(reservation);
        return ResponseEntity.status(201).body(createdReservation); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        Reservation existingReservation = reservationService.getReservationById(id);
        if (existingReservation == null) {
            return ResponseEntity.notFound().build();
        }
        updatedReservation.setId(id); // Ensure the ID remains consistent
        return ResponseEntity.ok(reservationService.updateReservation(updatedReservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        Reservation existingReservation = reservationService.getReservationById(id);
        if (existingReservation == null) {
            return ResponseEntity.notFound().build();
        }
        reservationService.removeReservation(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
