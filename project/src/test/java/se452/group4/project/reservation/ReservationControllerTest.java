package se452.group4.project.reservation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReservationControllerTest extends BaseReservationTest {
    
    @Autowired
    ReservationController controller;

    ReservationService service;

    public ReservationControllerTest() {
        service = mock(ReservationService.class);
    }

    @Test
    public void testGetAllReservations() throws ReservationException {
        // Arrange
        controller.service = service;
        var list = new ArrayList<Reservation>();
        list.add(new Reservation());
        list.add(new Reservation());
        
        when(service.GetAllReservations()).thenReturn(list);

        // Act
        var result = controller.list();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetReservationById() throws ReservationException {
        // Arrange
        controller.service = service;
        var r = createReservation();
        when(service.GetReservationById(r.getId())).thenReturn(r);
        // Act
        var result = controller.get(r.getId());

        // Assert
        assertNotNull(result);
        assertEquals(r, result);
    }

    @Test
    public void testUpsertReservation() throws ReservationException {
        // Arrange
        controller.service = service;
        var r = createReservation();
        when(service.UpsertReservation(r)).thenReturn(r);

        // Act
        var result = controller.upsert(r);

        // Assert
        assertNotNull(result);
        assertEquals(r, result);
    }

    @Test
    public void testSaveNewReservation() throws ReservationException {
        // Arrange
        var r = createReservation();

        // Act
        var result = controller.save(r);
        
        // Assert
        assertNotNull(result);
        assertEquals(r, result);
    }

    @Test
    public void testDeleteReservationById() throws ReservationException {
        // Arrange
        controller.service = service;
        var r = createReservation();
        controller.save(r);
        
        // Act
        controller.delete(r.getId());
        var result = controller.list();

        // Assert
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
