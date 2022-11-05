package se452.group4.project.reservation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

/**
 * The REST API Controller for Reservation CRUD Services for FlixNet. 
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reservation")
@Tag(name = "Reservation", description = "Functionality for interacting with FlixNet Reservations.")
@Log4j2 
public class ReservationController {
    @Autowired
    protected ReservationService service;

    /**
     * Retrieves all the Reservations in the FlixNet Database.  
    */
    @GetMapping
    @Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
    public ResponseEntity<ReservationResponse> list() throws ReservationException {
        log.traceEntry("ENTER: list all reservations.");
        try {
            var retval = service.GetAllReservations();
            log.traceExit("EXIT: list all reservations.");
            return new ResponseEntity<ReservationResponse>(retval, HttpStatus.OK);
        }
        catch(ReservationException e) {
            throw new ResponseStatusException(e.status, e.getMessage());
        }
    }

    /**
     * Retrieves a Reservation object based on an id in the FlixNet Database.
     * @param id
     * @return
     * @throws ReservationException
     */
    @GetMapping("/{id}")
    @Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
    public ResponseEntity<ReservationResponse> get(@PathVariable("id") UUID id) throws ReservationException {
        log.traceEntry("ENTER: get reservation by id.");
        try {
            var retval = service.GetReservationById(id);
            log.traceExit("EXIT: get reservation by id.");
            return new ResponseEntity<ReservationResponse>(retval, HttpStatus.OK);
        }
        catch(ReservationException e) {
            throw new ResponseStatusException(e.status, e.getMessage());
        }
    }

    /**
     * Saves a Reservation object to the FlixNet Database.
     * @param reservation
     * @return Reservation
     */
    @PostMapping
    @Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
    public ResponseEntity<ReservationResponse> save(@RequestBody Reservation reservation) throws ReservationException {
        log.traceEntry("ENTER: save reservation.", reservation);
        try {
            var retval = service.CreateReservation(reservation);
            log.traceExit("EXIT: save reservation.", reservation);
            return new ResponseEntity<ReservationResponse>(retval, HttpStatus.OK);
        }
        catch(ReservationException e) {
            throw new ResponseStatusException(e.status, e.getMessage());
        }

    }


    /**
     * Upserts a Reservation object in the FlixNet Database (Create if doesn't exist / update if id is present).
     * @param id
     * @param reservation
     * @return
     */
    @PutMapping()
    @Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
    public ResponseEntity<ReservationResponse> upsert(@RequestBody Reservation reservation) throws ReservationException {
        log.traceEntry("ENTER: upsert reservation.", reservation);
        try {
            var retval = service.UpsertReservation(reservation);
            log.traceExit("EXIT: upsert reservation.", reservation);
            return new ResponseEntity<ReservationResponse>(retval, HttpStatus.OK);
        }
        catch(ReservationException e) {
            throw new ResponseStatusException(e.status, e.getMessage());
        }
    }

    /**
     * Deletes a Reservation object from the FlixNet Database.
     * @param id
     */
    @DeleteMapping("/{id}")
    @Secured({ "ROLE_CUSTOMER", "ROLE_ADMIN" })
    public ResponseEntity<ReservationResponse> delete(@PathVariable("id") UUID id) throws ReservationException {
        log.traceEntry("ENTER: delete reservation.", id);
        try {
            var retval = service.DeleteReservationById(id);
            log.traceExit("EXIT: delete reservation.", id);
            return new ResponseEntity<ReservationResponse>(retval, HttpStatus.OK);
        }
        catch(ReservationException e) {
            throw new ResponseStatusException(e.status, e.getMessage());
        }
    }
}
