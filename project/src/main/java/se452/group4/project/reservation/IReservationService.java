package se452.group4.project.reservation;

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
    public ReservationResponse GetReservationById(UUID id) throws ReservationException;

    /**
     * Upserts a Reservation object based on the new data structure. Create/Insert or Update.
     * @param id
     * @param newReservation
     * @return
     */
    public ReservationResponse UpsertReservation(Reservation newReservation) throws ReservationException;

    /**
     * Creates a new Reservation object.
     * @param newReservation
     * @return
     */
    public ReservationResponse CreateReservation(Reservation newReservation) throws ReservationException;

    /**
     * Deletes a Reservation based on a given unique identifier for it.
     * @param id
     * @return 
     */
    public ReservationResponse DeleteReservationById(UUID id) throws ReservationException;

    /**
     * finds all the Reservations based on a given customer.
     * @param customerId
     * @return
     */
    public ReservationResponse GetReservationsByCustomerId(UUID customerId) throws ReservationException;

    /**
     * finds all the Reservations based on an exact description.
     * @param description
     * @return
     */
    public ReservationResponse GetReservationsByDescription(String description) throws ReservationException;

    /**
     * finds all the Reservations based on a given showtime.
     * @param showTimeId
     * @return
     */
    public ReservationResponse GetReservationsByShowTimeId(UUID showTimeId) throws ReservationException;
}
