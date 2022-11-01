package se452.group4.project.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReservationServiceTest extends BaseReservationTest {
    
    @Autowired
    ReservationService service;

    IReservationRepo repo;

    public ReservationServiceTest() {
        repo = mock(IReservationRepo.class);
    }

    @AfterEach 
    private void dispose(){
        repo.deleteAll();
    }
    
    @Test
    public void testGetAllReservations() throws ReservationException {
        service.repo = repo;
        var rs = new ArrayList<Reservation>();
        rs.add(createReservation());
        rs.add(createReservation());
        when(repo.findAll()).thenReturn(rs);

        var result = service.GetAllReservations();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(rs.get(0), result.get(0));
    }

    @Test
    public void testGetReservationById() throws ReservationException {
        service.repo = repo;
        var r = createReservation();

        when(repo.findById(r.getId())).thenReturn(Optional.of(r));

        var result = service.GetReservationById(r.getId());

        assertNotNull(result);
        assertEquals(r, result);
    }

    @Test
    public void testUpsertReservationUpdate() throws ReservationException {
        service.repo = repo;
        var r = createReservation();
        var newR = createReservation();
        newR.setDescription("UpdatedUnitTestDesc");

        when(repo.existsById(r.getId())).thenReturn(true);
        when(repo.findById(r.getId())).thenReturn(Optional.of(r));
        when(repo.save(newR)).thenReturn(newR);
        var result = service.UpsertReservation(newR);
        
        assertNotNull(result);
        assertEquals(newR.getDescription(), result.getDescription());
    }

    @Test
    public void testUpsertReservationInsert() throws ReservationException {
        service.repo = repo;
        var r = createReservation();

        when(repo.existsById(r.getId())).thenReturn(false);
        when(repo.save(r)).thenReturn(r);

        var result = service.UpsertReservation(r);

        assertNotNull(result);
        assertEquals(r, result);
    }

    @Test
    public void testCreateReservation() throws ReservationException {
        service.repo = repo;
        var r = createReservation();

        when(repo.save(r)).thenReturn(r);

        var result = service.CreateReservation(r);

        assertNotNull(result);
        assertEquals(r,result);
    }

    @Test
    public void testDeleteReservationById() throws ReservationException {
        service.repo = repo;
        var r = createReservation();

        when(repo.findById(r.getId())).thenReturn(Optional.of(r));

        service.CreateReservation(r);
        service.DeleteReservationById(r.getId());

        var result = service.GetAllReservations();
        assertEquals(0, result.size());
    }
}
