package se452.group4.project.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.assertj.core.util.IterableUtil;
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
    // @Test
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
    // @Test
    public void testFindByDescription() {
        // ARRANGE
        var r = createReservation();
        var desc1 = "UnitTestDescription";

        // ACT
        repo.save(r);
        var r1 = repo.findByDescription(desc1);
        // ASSERT
        assertEquals(1, IterableUtil.sizeOf(r1));
        assertEquals(desc1, r1.iterator().next().getDescription());
    }
    
    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD - find by showtimeId
     */
    // @Test
    public void testFindByShowTimeId() {
        // ARRANGE
        var r = createReservation();

        // ACT
        repo.save(r);
        var result = repo.findByShowTimeId(r.getShowTimeId());

        // ASSERT
        assertEquals(1, IterableUtil.sizeOf(result));
        assertEquals(r.getShowTimeId(), result.iterator().next().getShowTimeId());
    }

    /**
     * TEST: ReservationRepository Extending JPARepository - CRUD - find by customerId
     */
    // @Test
    public void testFindByCustomerId() {
        // ARRANGE
        var r = createReservation();

        // ACT
        repo.save(r);
        var result = repo.findByCustomerId(r.getCustomerId());

        // ASSERT
        assertEquals(1, IterableUtil.sizeOf(result));
        assertEquals(r.getCustomerId(), result.iterator().next().getCustomerId());
    }

}
