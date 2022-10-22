package se452.group4.project.customer;

import java.util.UUID;

/**
 * Interface for interacting with the Repository Layer an Customer Objects in the DB.
 */
public interface ICustomerService {

    /**
     * Gets a Customer based on a Unique Identifier for it.
     * @param id
     * @return
     * @throws CustomerException
     */
    public Customer GetCustomerById(UUID id) throws CustomerException;

    /**
     * Upserts a Customer object based on the new data structure. Create/Insert or Update.
     * @param id
     * @param newCustomer
     * @return
     */
    public Customer UpsertCustomer(Customer newCustomer) throws CustomerException;

    /**
     * Creates a new Customer object.
     * @param newCustomer
     * @return
     */
    public Customer CreateCustomer(Customer newCustomer) throws CustomerException;

    /**
     * Deletes a Customer based on a given unique identifier for it.
     * @param id
     */
    public void DeleteCustomerById(UUID id) throws CustomerException;
}
