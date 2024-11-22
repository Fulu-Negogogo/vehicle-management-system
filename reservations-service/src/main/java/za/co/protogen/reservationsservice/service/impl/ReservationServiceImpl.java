package za.co.protogen.reservationsservice.service.impl;

import org.springframework.stereotype.Service;
import za.co.protogen.reservationsservice.domain.Reservation;
import za.co.protogen.reservationsservice.service.ReservationService;
import za.co.protogen.reservationsservice.utility.Constant;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public Reservation addReservation(Reservation reservation) {
        Constant.getReservations().add(reservation);
        return reservation;
    }

    @Override
    public void removeReservation(Long id) {
        Constant.getReservations().removeIf(reservation -> reservation.getId().equals(id));
    }

    @Override
    public Reservation getReservationById(Long id) {
        return Constant.getReservations().stream()
                .filter(reservation -> reservation.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return Constant.getReservations();
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        Reservation existingReservation = getReservationById(reservation.getId());
        if (existingReservation != null) {
            existingReservation.setCarModel(reservation.getCarModel());
            existingReservation.setCustomerName(reservation.getCustomerName());
            existingReservation.setReservationDate(reservation.getReservationDate());
        }
        return existingReservation;
    }
}
