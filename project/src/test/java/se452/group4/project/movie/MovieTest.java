package se452.group4.project.movie;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MovieTest {  
    @DisplayName("Test title argument requirement")
    @Test
    public void testTitleNotNull() {
        assertThrows(
            NullPointerException.class, 
            () -> new Movie(null, "Here's a Description...", 100)
        );
    }

    @DisplayName("Test description argument requirement")
    @Test
    public void testDescriptionNotNull() {
        assertThrows(
            NullPointerException.class, 
            () -> new Movie("Here's a Title", null, 100)
        );
    }

    @DisplayName("Test Entity Id Inheritance")
    @Test
    public void testEntityIdInheritance() {
            Movie _m = new Movie("Here's a Title", "Here's a Description...", 100);
            assertTrue(_m.getId() != null);
    }

    @DisplayName("Test Entity Created Inheritance")
    @Test
    public void testEntityCreatedInheritance() {
            Movie _m = new Movie("Here's a Title", "Here's a Description...", 100);
            assertTrue(_m.getCreated() != null);
    }
}
