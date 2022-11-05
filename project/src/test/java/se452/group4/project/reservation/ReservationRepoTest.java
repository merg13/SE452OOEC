package se452.group4.project.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReservationRepoTest extends BaseReservationTest {

    // @Autowired uses Spring to instantiate an instance of the ReservationRepository for use in unit testing. 
    @Autowired
    public ReservationRepository repo;

    public ReservationRepoTest() {
    }

    @AfterEach 
    private void dispose(){
        repo.deleteAll();
    }

    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD
     */
    @Test
    public void testRepoCRUD() {
        // ARRANGE
        var r = createReservation();

        // ACT
        repo.save(r);

        // ASSERT - Assertion Includes seed data from data.sql.
        assertEquals(1, repo.count());
    }

    /**
     * TEST: ReservationRepository Extending JPARepository - find by description
     */
    @Test
    public void testFindByDescription() {
        // ARRANGE
        var r = createReservation();
        var desc1 = "UnitTestDescription";

        // ACT
        repo.save(r);
        var r1 = repo.findByDescription(desc1);
        // ASSERT
        assertEquals(1, r1.size());
        assertEquals(desc1, r1.get(0).getDescription());
    }

    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD - find by startTime
     */
    @Test
    public void testFindByStartTime() {
        // ARRANGE
        var r = createReservation();
        var firstSearchDateTime = LocalDateTime.now().minusDays(1);
        var secondSearchDateTime = LocalDateTime.now().plusDays(1);

        // ACT
        repo.save(r);
        var result = repo.findByStartTimeBetween(firstSearchDateTime, secondSearchDateTime);

        // ASSERT
        assertNotNull(result);
        assertEquals(2, result.size());
    }
    
    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD - find by showtimeId
     */
    @Test
    public void testFindByShowTimeId() {
        // ARRANGE
        var r = createReservation();

        // ACT
        repo.save(r);
        var result = repo.findByShowTimeId(r.getShowTimeId());

        // ASSERT
        assertEquals(1, result.size());
        assertEquals(r.getShowTimeId(), result.get(0).getShowTimeId());
    }

    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD - find by customerId
     */
    @Test
    public void testFindByCustomerId() {
        // ARRANGE
        var r = createReservation();

        // ACT
        repo.save(r);
        var result = repo.findByCustomerId(r.getCustomerId());

        // ASSERT
        assertEquals(1, result.size());
        assertEquals(r.getCustomerId(), result.get(0).getCustomerId());
    }

}
