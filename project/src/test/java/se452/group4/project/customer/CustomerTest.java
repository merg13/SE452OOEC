package se452.group4.project.customer;

import java.util.UUID;
import java.text.MessageFormat;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTest {  
    // @Autowired uses Spring to instantiate an instance of the CustomerRepo for use in unit testing. 
    @Autowired
    private CustomerRepo repo;

    /**
     * TEST: CustomerRepo Extending JPARepository - CRUD
     */
    @DisplayName("Test CustomerRepo")
    @Test
    public void testCustomerRepositoryCRUD() {
        // ARRANGE
        var customer = createCustomer();

        // ACT
        repo.save(customer);

        // ASSERT - Assertion Includes seed data from data.sql.
        assertEquals(2, repo.count());
    }

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

    public Customer createCustomer() {
        Customer customer = new Customer("John Smith");

        customer.setId(UUID.randomUUID());
        customer.setCreated(LocalDateTime.now());

        return customer;
    }  
}
