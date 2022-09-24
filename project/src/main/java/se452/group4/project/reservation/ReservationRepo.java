package se452.group4.project.reservation;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The repository is responsible for interacting with the database to perform CRUD opterations for FlixNet Reservations.
 * @see JpaRepository that extends PagingAndSortingRepository that expands CrudRepository
 */
public interface ReservationRepo extends JpaRepository<Reservation, UUID>  {
    
}
