package se452.group4.project.customer;

import java.util.UUID;

public class CustomerException extends Exception {
    public static String GetCustomerByIdError = "ERROR: GetCustomerByIdError: could not successfully get CustomerById: ";
    public static String UpsertCustomerError = "ERROR: UpsertCustomerError: could not successfully upsert CustomerById: ";
    public static String CreateCustomerError = "ERROR: CreateCustomerError: could not successfully create Customer.";
    public static String DeleteCustomerByIdError = "ERROR: DeleteCustomerByIdError: could not successfully delete CustomerById: ";

    public CustomerException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
    
    public CustomerException(UUID id, String errorMessage, Throwable cause) {
        super(errorMessage + id.toString(), cause);
    }

    public CustomerException() {
    }
}
