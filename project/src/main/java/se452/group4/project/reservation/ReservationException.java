package se452.group4.project.reservation;

import java.util.UUID;
import org.springframework.http.HttpStatus;

/**
 * Base Exception Class for Reservations in the FlixNet system.
 */
public class ReservationException extends Exception {
    public static String GetAllReservationsError = "ERROR: GetAllReservations: could not successfully get all reservations.";
    public static String GetReservationByIdError = "ERROR: GetReservationById: could not successfully get ReservationById: ";
    public static String UpsertReservationError = "ERROR: UpsertReservation: could not successfully upsert ReservationById: ";
    public static String CreateReservationError = "ERROR: CreateReservarion: could not successfully create Reservation.";
    public static String DeleteReservationByIdError = "ERROR: DeleteReservationById: could not successfully delete ReservationById: ";

    public HttpStatus status;

    public ReservationException(HttpStatus status, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.status = status;
    }
    
    public ReservationException(HttpStatus status, UUID id, String errorMessage, Throwable cause) {
        super(errorMessage + id.toString(), cause);
        this.status = status;
    }

    public ReservationException() {
    }
}
