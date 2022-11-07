package se452.group4.project.security.user;

public interface IUserRegistrationServiceImpl {
    /**
     * Gets a User based on their username from the FlixNet system.
     * @param username
     * @return
     * @throws UserException
     */
    UserResponse getUser(String username) throws UserException;

    /**
     * Registers a new User with the FLixNet system.
     * @param request
     * @return
     * @throws UserException
     */
    UserRegistrationReponse registerUser(UserRegistrationRequest request) throws UserException;
}
