package se452.group4.project.reservation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

/**
 * The REST API Controller for Reservation CRUD Services for FlixNet. 
 */
@RestController
@RequestMapping("/api/reservation")
@Log4j2 
public class ReservationController {
    @Autowired
    private ReservationRepo repo;

    /**
     * Retrieves a List<Reservation> for all the Reservations in the FlixNet Database.  
    */
    @GetMapping
    public List<Reservation> list() {
        log.traceEntry("ENTER: list all reservations");
        var retval = repo.findAll();
        log.traceExit("EXIT: list all reservations.");
        return retval;
    }

    /**
     * Saves a Reservation object to the FlixNet Database.
     * @param reservation
     * @return Reservation
     */
    @PostMapping
    public Reservation save(@RequestBody Reservation reservation) {
        log.traceEntry("ENTER: save reservation", reservation);
        repo.save(reservation);
        log.traceExit("EXIT: save reservation", reservation);
        return reservation;
    }

    /**
     * Deletes a Reservation object from the FlixNet Database.
     * @param id
     */
    @DeleteMapping()
    public void deleteCourse(String id) {
        log.traceEntry("ENTER: delete reservation", id);
        repo.deleteById(UUID.fromString(id));
        log.traceExit("EXIT: delete reservation", id);
    }
}
