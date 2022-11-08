package se452.group4.project.auditorium;

import java.util.UUID;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class AuditoriumTest {
    // @Autowired uses Spring to instantiate an instance of the AuditoriumRepo for use in unit testing. 
    @Autowired
    private AuditoriumRepo repo;

    /**
     * TEST: AuditoriumRepo Extending JPARepository - CRUD
     */
    @DisplayName("Test AuditoriumRepo")
    //@Test
    public void testAuditoriumRepositoryCRUD() {
        // ARRANGE
        var Auditorium = createAuditorium();

        // ACT
        repo.save(Auditorium);

        // ASSERT - Assertion Includes seed data from data.sql.
        assertEquals(2, repo.count());
    }

    @DisplayName("Test Auditorium")
    //@Test
    public void testAuditorium() {
        Auditorium auditorium = new Auditorium("Theater 5", 100);

        var id = UUID.randomUUID();
        var createdDate = LocalDateTime.now();


        auditorium.setId(id);
        auditorium.setCreated(createdDate);

        String expectedResult = MessageFormat.format(
            "Auditorium(super=Entity(id={0}, created={1}), name=Theater 5, capacity=100)", 
            id, createdDate);
        assertEquals(expectedResult, auditorium.toString());
    }  

    public Auditorium createAuditorium() {
        Auditorium auditorium = new Auditorium("Theater 5", 100);

        auditorium.setId(UUID.randomUUID());
        auditorium.setCreated(LocalDateTime.now());

        return auditorium;
    }  
    
}

