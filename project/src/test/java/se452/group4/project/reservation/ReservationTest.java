package se452.group4.project.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootTest
public class ReservationTest {
    
    // @Autowired uses Spring to instantiate an instance of the ReservationRepository for use in unit testing. 
    @Autowired
    private ReservationRepo repo;

    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD
     */
    @Test
    public void testReservationRepositoryCRUD() {
        // ARRANGE
        var r = createReservation();

        // ACT
        repo.save(r);

        // ASSERT - Assertion Includes seed data from data.sql.
        assertEquals(2, repo.count());
    }

    /**
     * TEST: Reservation Object ToString w/ LOMBOK
     */
    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD
     */
    @Test
    public void testReservationRepositoryCRUD() {
        // ARRANGE
        var r = createReservation();

        // ACT
        repo.save(r);

        // ASSERT - Assertion Includes seed data from data.sql.
        assertEquals(2, repo.count());
    }

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

    private Reservation createReservation() {
        var r = new Reservation();
        r.setId(UUID.randomUUID());
        r.setCreated(LocalDateTime.now());
        r.setDescription("UnitTestDescription");
        r.setStartTime(LocalDateTime.now().plusHours(5));
        r.setCustomerId(UUID.randomUUID());
        r.setShowTimeId(UUID.randomUUID());

        return r;
    }

    private Reservation createReservation() {
        var r = new Reservation();
        r.setId(UUID.randomUUID());
        r.setCreated(LocalDateTime.now());
        r.setDescription("UnitTestDescription");
        r.setStartTime(LocalDateTime.now().plusHours(5));
        r.setCustomerId(UUID.randomUUID());
        r.setShowTimeId(UUID.randomUUID());

        return r;
    }
}
