package se452.group4.project.reservation;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Interface for interacting with the Repository Layer an Reservation Objects in the DB.
 */
public interface IReservationService {
    
    /**
     * Gets all Reservations.
     * @return
     */
    public ReservationResponse GetAllReservations() throws ReservationException;

    /**
     * Gets a Reservation based on a Unique Identifier for it.
     * @param id
     * @return
     * @throws ReservationException
     */
    public ReservationResponseResponse GetReservationById(UUID id) throws ReservationException;

    /**
     * Upserts a Reservation object based on the new data structure. Create/Insert or Update.
     * @param id
     * @param newReservation
     * @return
     */
    public ReservationResponseResponse UpsertReservation(Reservation newReservation) throws ReservationException;

    /**
     * Creates a new Reservation object.
     * @param newReservation
     * @return
     */
    public ReservationResponseResponse CreateReservation(Reservation newReservation) throws ReservationException;

    /**
     * Deletes a Reservation based on a given unique identifier for it.
     * @param id
     * @return 
     */
    public ReservationResponse DeleteReservationById(UUID id) throws ReservationException;

    /**
     * finds all the reservations based on a given start time range.
     * @param firstDateTime
     * @param secondDateTime
     * @return
     */
    public ReservationResponse GetReservationsBetweenStartTime(LocalDateTime firstDateTime, LocalDateTime secondDateTime); 

    /**
     * finds all the Reservations based on a given customer.
     * @param customerId
     * @return
     */
    public ReservationResponse GetReservationsByCustomerId(UUID customerId);

    /**
     * finds all the Reservations based on an exact description.
     * @param description
     * @return
     */
    public ReservationResponse GetReservationsByDescription(String description);

    /**
     * finds all the Reservations based on a given showtime.
     * @param showTimeId
     * @return
     */
    public ReservationResponse GetReservationsByShowTimeId(UUID showTimeId);
}
