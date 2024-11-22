package za.co.protogen.reservationsservice.service;

import za.co.protogen.reservationsservice.domain.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    void removeReservation(Long id);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
    Reservation updateReservation(Reservation reservation);
}
