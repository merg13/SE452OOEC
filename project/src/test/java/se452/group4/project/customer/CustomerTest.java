package se452.group4.project.customer;

import java.util.UUID;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {  
    @DisplayName("Test Customer")
    @Test
    public void testCustomer() {
        Customer customer = new Customer("John Smith");

        var id = UUID.randomUUID();
        var createdDate = LocalDateTime.now();

        customer.setId(id);
        customer.setCreated(createdDate);
        String expectedResult = MessageFormat.format(
            "Customer(super=Entity(id={0}, created={1}), name=John Smith)", 
            id, createdDate);
        assertEquals(expectedResult, customer.toString());
    }  
}
