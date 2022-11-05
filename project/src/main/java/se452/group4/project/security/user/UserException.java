package se452.group4.project.security.user;
import java.util.UUID;
import org.springframework.http.HttpStatus;

/**
 * Base Exception Class for Users in the FlixNet system.
 */
public class UserException extends Exception {
    public static final String GenericUserRegistration = "registerUser: could not successfully register user.";
    public static final String UserExists = "registerUser: Username already exists.";
    public static final String InvalidPassword = "registerUser: Invalid password doesn't meet password requirements.";
    public static final String InvalidUserRole = "registerUser: Invalid User role does not exist.";
    public static final String GenericGetUsername = "getUser: could not successfully retrieve user.";
    public HttpStatus status;

    public UserException(HttpStatus status, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.status = status;
    }
    
    public UserException(HttpStatus status, UUID id, String errorMessage, Throwable cause) {
        super(errorMessage + id.toString(), cause);
        this.status = status;
    }

    public UserException() {

    }
}
