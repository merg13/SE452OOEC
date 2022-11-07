package se452.group4.project.security.user;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/auth/user")
@Tag(name = "User", description = "Functionality for interacting with Users of FlixNet.")
public class UserController {
    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping()
    public ResponseEntity<UserResponse> getUser(String username) {
        try {
            log.traceEntry("START: registerUser", username);
            var retval = userRegistrationService.getUser(username);
            log.traceExit("END: registerUser", retval);     
            
            if (retval.errors.size() > 0) {
                return new ResponseEntity<UserResponse>(retval, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<UserResponse>(retval, HttpStatus.OK);
        }
        catch(UserException e) {
            throw new ResponseStatusException(e.status, e.getMessage());
        }
    }

    
    @PostMapping("/register")
    public ResponseEntity<UserRegistrationReponse> registerUser(UserRegistrationRequest request) {
        try {
            log.traceEntry("START: registerUser", request);
            var retval = userRegistrationService.registerUser(request);
            log.traceExit("END: registerUser", retval);

            if (retval.errors.size() > 0) {
                return new ResponseEntity<UserRegistrationReponse>(retval, HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity<UserRegistrationReponse>(retval, HttpStatus.OK);
        }
        catch (UserException e) {
            throw new ResponseStatusException(e.status, e.getMessage());
        }
    }
}
