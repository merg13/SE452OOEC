package se452.group4.project.reservation;

import java.util.List;
import java.util.UUID;

/**
 * Interface for interacting with the Repository Layer an Reservation Objects in the DB.
 */
public interface IReservationService {
    
    /**
     * Gets all Reservations.
     * @return
     */
    public List<Reservation> GetAllReservations() throws ReservationException;

    /**
     * Gets a Reservation based on a Unique Identifier for it.
     * @param id
     * @return
     * @throws ReservationException
     */
    public Reservation GetReservationById(UUID id) throws ReservationException;

    /**
     * Upserts a Reservation object based on the new data structure. Create/Insert or Update.
     * @param id
     * @param newReservation
     * @return
     */
    public Reservation UpsertReservation(Reservation newReservation) throws ReservationException;

    /**
     * Creates a new Reservation object.
     * @param newReservation
     * @return
     */
    public Reservation CreateReservation(Reservation newReservation) throws ReservationException;

    /**
     * Deletes a Reservation based on a given unique identifier for it.
     * @param id
     */
    public void DeleteReservationById(UUID id) throws ReservationException;
}
