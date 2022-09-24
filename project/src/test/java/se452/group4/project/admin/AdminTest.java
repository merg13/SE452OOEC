package se452.group4.project.admin;

import java.util.UUID;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {  

    // @Autowired uses Spring to instantiate an instance of the AdminRepo for use in unit testing. 
    @Autowired
    private AdminRepo repo;

    /**
     * TEST: AdminRepo Extending JPARepository - CRUD
     */
    @DisplayName("Test AdminRepo")
    @Test
    public void testAdminRepositoryCRUD() {
        // ARRANGE
        var admin = createAdmin();

        // ACT
        repo.save(admin);

        // ASSERT - Assertion Includes seed data from data.sql.
        assertEquals(2, repo.count());
    }

    /**
     * TEST: Admin Creation
     */
    @DisplayName("Test Admin")
    @Test
    public void testAdminCreation() {
        Admin admin = new Admin();
        var id = UUID.randomUUID();
        var createdDate = LocalDateTime.now();
        admin.setId(id);
        admin.setCreated(createdDate);
        String expectedResult = MessageFormat.format(
            "Admin(super=Entity(id={0}, created={1}))", 
            id, createdDate);

        assertEquals(expectedResult, admin.toString());
    }  

    private Admin createAdmin() {
        var admin = new Admin();
        admin.setId(UUID.randomUUID());
        admin.setCreated(LocalDateTime.now());

        return admin;
    }
}
