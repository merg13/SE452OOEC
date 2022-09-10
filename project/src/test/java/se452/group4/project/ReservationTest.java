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
        var showTimeId = UUID.randomUUID();
        var customerId = UUID.randomUUID();
        var startTime = LocalDateTime.now(); 
        var description = "Some important Description of a reservation for a movie.";

        var expectedResult = MessageFormat.format(
            "Reservation(id={0}, description={1}, startTime={2}, showTimeId={3}, customerId={4})", 
            id, description, startTime, showTimeId, customerId);

        r.id = id;
		r.showTimeId = showTimeId;
		r.customerId = customerId;
		r.startTime = startTime;
		r.description = description;
		assertEquals(expectedResult, r.toString());
    }
}
