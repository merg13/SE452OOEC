/**
 * This package holds all functionality related to reservations for FlixNet.
 * @version 0.0.1
 * @author Mitchell Ergen
 * 
 * <h1>Package Overview</h1>
 * 
 *  <h2>Reservation</h2>
 *  <ul><li>Entity for interacting with data related to Reservations. 
 *      It extends our se452.group4.project.entity.Entity abstract class which provides it with an unique identifier and created timestamp. 
 *      It is then extended with reservation specific metadata.</li></ul>
 * 
 *  <h3>LOMBOK Usage:</h3>
 * 
 * <ul>
 *  <li>@Data - Generates getters/setters for the properties on the object.</li>
 *  <li>@AllArgsConstructor - Generates a Standard constructor that includes parameters for each property on the object.</li>
 *  <li>@EqualsAndHashCode(callSuper = true) - Standard Equals and HashCode methods based on the object structure and its properties.</li>
 *  <li>@ToString(callSuper = true) - Since Reservation Extends the abstract Entity class, the <em>callSuper=true</em> allows the ToString method to also display the base class properties.</li>
 *  <li>@Entity - specifies that the annotaed model is an Entity for use in persistence through java persistence, the ReservationRepository,
 *       which extends the JPARepository for CRUD operations to the Database.</li>
 * </ul>
 * 
 * ///////////////////////////////////
 * 
 * <h2>ReservationRepositoryJPA</h2>
 * <ul><li>Through the ReservationRepositoryJPA, The Reservation Entity interacts with a H2 database using the repository pattern extending a JPARepository.</li></ul>
 * <ul>
 *  <li>findByStartTimeBetween - allows for the ability to find all reservations based on a given start time range.</li>
 *  <li>findByShowTimeId - allows for the ability to find all reservations based on a given showtime.</li>
 *  <li>findByCustomerId - allows for the ability to find all reservations based on a given customer.</li>
 *  <li>findByDescription - allows for the ability to find all reservations based on an exact description.</li>
 * </ul>
 * 
 * ///////////////////////////////////
 * 
 * <h2>ReservationController</h2>
 *  <ul>
 *      <li>@Secured("ROLE_CUSTOMER", "ROLE_ADMIN") is used on routes to ensure the logged in session user is able to interact with endpoints before any other logic occurs.</li>
 *      <li>@Tag(...) is used to provide a more descript swagger documentation for the Controller.</li>
 *      <li>A Single @Autowired service is instantiated for business logic encapsulation in the service. 
 *          This leaves the controller clean of business logic and free for response formation, logging, and exception handling.</li>
 *      <li>Endpoints throw the customer ReservationResponse and return ResponseEntity<ReservationResponse> on success and ResponseStatusExceptions on errors</li>
 *      <li>Reservation POST and PUT calls utilize a JSON @RequestBody parameter and DELETE Calls utilize a @PathVariable for the UUID of the Reservation.</li>
 *      <li>Endpoints are decorated with @Tag and @Operation for more descript Swagger Documentation.</li>
 *  </ul>
 * 
 * ///////////////////////////////////
 * 
 * <h2>ReservationService</h2>
 *  <p>
 *      implementation of IReservationService interface. Provides CRUD and Find operations for Reservations. 
 *      Returns a custom ReservationResponse with Success boolean, Errors Set of Strings, and List of Reservation objects. 
 *      This provides consistent expectations of repsonses from this service.
 *  </p>
 *  <ul>
 *      <li>GetAllReservations</li>
 *      <li>GetReservationById</li>
 *      <li>UpsertReservation</li>
 *      <li>CreateReservation</li>
 *      <li>DeleteReservationById</li>
 *      <li>GetReservationsBetweenStartTime</li>
 *      <li>GetReservationsByCustomerId</li>
 *      <li>GetReservationsByDescription</li>
 *      <li>GetReservationsByShowTimeId</li>
 *  </ul>
 * 
 * ///////////////////////////////////
 * 
 * <h2>ReservationException</h2>
 * <ul>
 *  <li>Extension of the base java Exception class used in the ReservationService to provide more specific exception handling for Reservations. Logging and proper exception handling can be invaluable for debugging large scale enterprise systems.</li>
 * </ul>
 * 
 * ///////////////////////////////////
 */
package se452.group4.project.reservation;
