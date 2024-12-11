package za.co.protogen.reservationsservice.adapter;

import za.co.protogen.reservationsservice.domain.Reservation;
import za.co.protogen.reservationsservice.dto.ReservationDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Mappers {

    public static ReservationDTO reservationToReservationDTO(Reservation reservation) {
        if (reservation == null) return null;

        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setUserId(reservation.getUserId());
        dto.setCarId(reservation.getCarId());
        dto.setFromDate(reservation.getFromDate());
        dto.setToDate(reservation.getToDate());
        dto.setPickUpLocation(reservation.getPickUpLocation());
        dto.setDropOffLocation(reservation.getDropOffLocation());
        return dto;
    }

    public static Reservation reservationDTOToReservation(ReservationDTO dto) {
        if (dto == null) return null;

        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setUserId(dto.getUserId());
        reservation.setCarId(dto.getCarId());
        reservation.setFromDate(dto.getFromDate());
        reservation.setToDate(dto.getToDate());
        reservation.setPickUpLocation(dto.getPickUpLocation());
        reservation.setDropOffLocation(dto.getDropOffLocation());
        return reservation;
    }

    public static List<ReservationDTO> reservationsToReservationDTOs(List<Reservation> reservations) {
        return reservations.stream().map(Mappers::reservationToReservationDTO).collect(Collectors.toList());
    }

    public static List<Reservation> reservationDTOsToReservations(List<ReservationDTO> dtos) {
        return dtos.stream().map(Mappers::reservationDTOToReservation).collect(Collectors.toList());
    }
}
