package se452.group4.project.showtime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShowtimeTest {
    @DisplayName("Test movie argument requirement")
    @Test
    public void testMovieNotNull() {
        assertThrows(
            NullPointerException.class, 
            () -> new Showtime(null, UUID.randomUUID(), LocalDateTime.now())
        );
    }

    @DisplayName("Test auditorium argument requirement")
    @Test
    public void testAuditoriumNotNull() {
        assertThrows(
            NullPointerException.class, 
            () -> new Showtime(UUID.randomUUID(), null, LocalDateTime.now())
        );
    }

    @DisplayName("Test time argument requirement")
    @Test
    public void testTimeNotNull() {
        assertThrows(
            NullPointerException.class, 
            () -> new Showtime(UUID.randomUUID(), UUID.randomUUID(), null)
        );
    }

    @DisplayName("Test Entity Id Inheritance")
    @Test
    public void testEntityIdInheritance() {
            Showtime _s = new Showtime(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
            assertTrue(_s.getId() != null);
    }
    
    @DisplayName("Test Entity Created Inheritance")
    @Test
    public void testEntityCreatedInheritance() {
            Showtime _s = new Showtime(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
            assertTrue(_s.getCreated() != null);
    }

}
