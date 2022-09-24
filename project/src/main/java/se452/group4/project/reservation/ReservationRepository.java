package se452.group4.project.reservation;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @see JpaRepository that extends PagingAndSortingRepository that expands CrudRepository
 */
public interface ReservationRepository extends JpaRepository<Reservation, UUID>  {
    
}
