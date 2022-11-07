// package se452.group4.project.reservation;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.UUID;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// /**
//  * The repository is responsible for interacting with the database to perform CRUD opterations for FlixNet Reservations.
//  * @see JpaRepository that extends PagingAndSortingRepository that expands CrudRepository
//  */
// public interface ReservationRepositoryInMemory extends JpaRepository<Reservation, UUID> {
//         /**
//      * finds all the reservations based on a given start time range.
//      * @param startTime
//      * @return List<Reservation>
//      */
//     public List<Reservation> findByStartTimeBetween(LocalDateTime firstDateTime, LocalDateTime secondDateTime);

//     /**
//      * finds all the Reservations based on a given showtime.
//      * @param showtime
//      * @return List<Reservation>
//      */
//     public List<Reservation> findByShowTimeId(UUID showTimeId);

//     /**
//      * finds all the Reservations based on a given customer.
//      * @param customer
//      * @return List<Reservation>
//      */
//     public List<Reservation> findByCustomerId(UUID customerId);
    

//     /**
//      * finds all the Reservations based on an exact description.
//      * @param description
//      * @return Reservation
//      */
//     public List<Reservation> findByDescription(String description);
// }
