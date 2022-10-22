package se452.group4.project.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReservationTest extends BaseReservationTest {
    
    /**
     * TEST: Reservation Object ToString w/ LOMBOK
     */
    @Test
    public void testToString() {
        var r = createReservation();

        var expectedResult = MessageFormat.format(
            "Reservation(super=Entity(id={0}, created={1}), description={2}, startTime={3}, showTimeId={4}, customerId={5})", 
            r.getId(), r.getCreated(), r.getDescription(), r.getStartTime(), r.getShowTimeId(), r.getCustomerId());
            
		assertEquals(expectedResult, r.toString());
    }
}
