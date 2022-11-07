package se452.group4.project.reservation;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, UUID> {
    /**
     * finds all the Reservations based on a given showtime.
     * @param showtime
     * @return List<Reservation>
     */
    public Iterable<Reservation> findByShowTimeId(UUID showTimeId);

    /**
     * finds all the Reservations based on a given customer.
     * @param customer
     * @return List<Reservation>
     */
    public Iterable<Reservation> findByCustomerId(UUID customerId);
    

    /**
     * finds all the Reservations based on an exact description.
     * @param description
     * @return Reservation
     */
    public Iterable<Reservation> findByDescription(String description);
}
