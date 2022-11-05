package se452.group4.project.security.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import se452.group4.project.security.enums.UserRoleType;
import se452.group4.project.security.userRole.UserRole;
import se452.group4.project.security.userRole.UserRoleRepository;

@Log4j2
@Service
public class UserRegistrationService implements IUserRegistrationServiceImpl {

    public final String PasswordRegEx = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    @Autowired
    private UserRepository userRepository;

    @Autowired 
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserRegistrationReponse registerUser(UserRegistrationRequest request) throws UserException {
        UserRegistrationReponse retval;
        log.info("START - registerUser:", request);
        try {
                // CASE: user already exists... let's not register it again.
            if (userRepository.findByUsername(request.getUsername()).isPresent()) {
                retval = UserRegistrationReponse.builder()
                    .errors(Set.of(UserException.UserExists))
                    .success(false)
                    .build();
                return retval;
            }

            // CASE: password isn't secure enough (i.e. doesn't match the RegEx).
            if (!validatePassword(request.getPassword())) {
                retval = UserRegistrationReponse.builder()
                    .errors(Set.of(UserException.InvalidPassword))
                    .success(false)
                    .build();
                return retval;
            }

            // CASE: user role doesn't exist.
            Set<UserRole> requestUserRoles = new HashSet<>();
            for (int i = 0; i < request.getRole().size(); i ++) {
                    var currentRole = ((String)request.getRole().toArray()[i]);
                    UserRoleType currentRoleEnum;
                    try {
                        currentRoleEnum = UserRoleType.valueOf(currentRole);
                    }
                    catch (Exception e) {
                        retval = UserRegistrationReponse.builder()
                            .errors(Set.of(UserException.InvalidUserRole))
                            .success(false)
                            .build();
                        return retval;
                    }

                    var roleOut = userRoleRepository.findByName(currentRoleEnum).get();
                    requestUserRoles.add(roleOut);
            }

            User newUser = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(encoder.encode(request.getPassword()))
            .roles(requestUserRoles)
            .build();

            userRepository.save(newUser);

            log.info("END - registerUser", newUser);

            retval = UserRegistrationReponse.builder()
                .errors(Set.of(new String[]{}))
                .success(true)
                .build();

            return retval;
        }
        catch (Exception e) {
            retval = UserRegistrationReponse.builder()
            .success(false)
            .errors(Set.of(UserException.GenericUserRegistration))
            .build();

            return retval;
        }
    }

    private boolean validatePassword(String password) {
        if (!password.matches(PasswordRegEx)) {
            return false;
        }

        return true; // Valid Password.
    }

    @Override
    public UserResponse getUser(String username) throws UserException {
        UserResponse retval;
        try {
            if(!userRepository.existsByUsername(username).booleanValue()) {
                retval = UserResponse.builder()
                    .user(null)
                    .success(false)
                    .errors(Set.of(UserException.GenericGetUsername))
                    .build();
            }
            else {
                var user = userRepository.findByUsername(username).get();
                
                retval = UserResponse.builder()
                    .user(user)
                    .success(true)
                    .errors(Set.of(new String[]{}))
                    .build();
            }
        }
        catch(Exception e) {
            retval = UserResponse.builder()
                .user(null)
                .success(false)
                .errors(Set.of(UserException.GenericGetUsername))
                .build();
        }
        return retval;
    }
    
}
