package se452.group4.project.reservation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    protected ReservationService service;

    /**
     * Retrieves a List<Reservation> for all the Reservations in the FlixNet Database.  
    */
    @GetMapping
    public List<Reservation> list() throws ReservationException {
        log.traceEntry("ENTER: list all reservations.");
        try {
            var retval = service.GetAllReservations();
            log.traceExit("EXIT: list all reservations.");
            return retval;
        }
        catch(ReservationException e) {
            throw e;
        }
    }

    /**
     * Retrieves a Reservation object based on an id in the FlixNet Database.
     * @param id
     * @return
     * @throws ReservationException
     */
    @GetMapping("/{id}")
    public Reservation get(@PathVariable("id") UUID id) throws ReservationException {
        log.traceEntry("ENTER: get reservation by id.");
        try {
            var retval = service.GetReservationById(id);
            log.traceExit("EXIT: get reservation by id.");
            return retval;
        }
        catch(ReservationException e) {
            throw e;
        }
    }

    /**
     * Saves a Reservation object to the FlixNet Database.
     * @param reservation
     * @return Reservation
     */
    @PostMapping
    public Reservation save(@RequestBody Reservation reservation) throws ReservationException {
        log.traceEntry("ENTER: save reservation.", reservation);
        try {
            service.CreateReservation(reservation);
            log.traceExit("EXIT: save reservation.", reservation);
            return reservation;
        }
        catch(ReservationException e) {
            throw e;
        }

    }


    /**
     * Upserts a Reservation object in the FlixNet Database (Create if doesn't exist / update if id is present).
     * @param id
     * @param reservation
     * @return
     */
    @PutMapping()
    public Reservation upsert(@RequestBody Reservation reservation) throws ReservationException {
        log.traceEntry("ENTER: upsert reservation.", reservation);
        try {
            var retval = service.UpsertReservation(reservation);
            log.traceExit("EXIT: upsert reservation.", reservation);
            return retval;
        }
        catch(ReservationException e) {
            throw e;
        }
    }

    /**
     * Deletes a Reservation object from the FlixNet Database.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) throws ReservationException {
        log.traceEntry("ENTER: delete reservation.", id);
        try {
            service.DeleteReservationById(id);
            log.traceExit("EXIT: delete reservation.", id);
        }
        catch(ReservationException e) {
            throw e;
        }
    }
}
