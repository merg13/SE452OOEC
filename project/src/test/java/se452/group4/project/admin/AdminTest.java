package se452.group4.project.admin;

import java.util.UUID;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AdminTest {  
    @DisplayName("Test Customer")
    @Test
    public void testAdmin() {
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
}
