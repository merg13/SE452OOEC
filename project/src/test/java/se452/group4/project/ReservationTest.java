package se452.group4.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import se452.group4.project.reservation.Reservation;

public class ReservationTest {
    

    @Test
    public void testToString() {
        var r = new Reservation();
        var id = UUID.randomUUID();
        var createdDate = LocalDateTime.now();
        var showTimeId = UUID.randomUUID();
        var customerId = UUID.randomUUID();
        var startTime = LocalDateTime.now(); 
        var description = "Some important Description of a reservation for a movie.";

        var expectedResult = MessageFormat.format(
            "Reservation(super=Entity(id={0}, created={1}), description={2}, startTime={3}, showTimeId={4}, customerId={5})", 
            id, createdDate, description, startTime, showTimeId, customerId);

        r.setId(id);
        r.setCreated(createdDate);
		r.showTimeId = showTimeId;
		r.customerId = customerId;
		r.startTime = startTime;
		r.description = description;
		assertEquals(expectedResult, r.toString());
    }
}
