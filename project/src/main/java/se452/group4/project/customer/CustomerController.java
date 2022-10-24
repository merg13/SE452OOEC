package se452.group4.project.customer;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

/**
 * The REST API Controller for Customer CRUD Services for FlixNet. 
 */
@RestController
@RequestMapping("/api/customer")
@Log4j2 
public class CustomerController {
    @Autowired
    protected CustomerService service;

    /**
     * Retrieves a Customer object based on an id in the FlixNet Database.
     * @param id
     * @return
     * @throws CustomerException
     */
    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") UUID id) throws CustomerException {
        log.traceEntry("ENTER: get Customer by id.");
        try {
            var customer = service.GetCustomerById(id);
            log.traceExit("EXIT: get Customer by id.");
            return customer;
        }
        catch(CustomerException e) {
            throw e;
        }
    }

    /**
     * Saves a Customer object to the FlixNet Database.
     * @param Customer
     * @return Customer
     */
    @PostMapping
    public Customer save(@RequestBody Customer customer) throws CustomerException {
        log.traceEntry("ENTER: save Customer.", customer);
        try {
            service.CreateCustomer(customer);
            log.traceExit("EXIT: save Customer.", customer);
            return customer;
        }
        catch(CustomerException e) {
            throw e;
        }

    }


    /**
     * Upserts a Customer object in the FlixNet Database (Create if doesn't exist / update if id is present).
     * @param id
     * @param Customer
     * @return
     */
    @PutMapping()
    public Customer upsert(@RequestBody Customer customer) throws CustomerException {
        log.traceEntry("ENTER: upsert Customer.", customer);
        try {
            var c = service.UpsertCustomer(customer);
            log.traceExit("EXIT: upsert Customer.", customer);
            return c;
        }
        catch(CustomerException e) {
            throw e;
        }
    }

    /**
     * Deletes a Customer object from the FlixNet Database.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) throws CustomerException {
        log.traceEntry("ENTER: delete Customer.", id);
        try {
            service.DeleteCustomerById(id);
            log.traceExit("EXIT: delete Customer.", id);
        }
        catch(CustomerException e) {
            throw e;
        }
    }
}
