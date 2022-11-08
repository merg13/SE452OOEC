/**
 * @author Eric Margules
 * <h2>Points of Interest MS1<h2>
 * <ul>
 *  <li>Lombok All Arg Constructor decorations</li>
 *  <li>Lombok NonNull decorator for required parameters</li>
 *  <li>Inheritance from base Entity class for Id/Created properties</li>
 *  <li>Add callSuper to toString and equals Lombok methods</li>
 *  <li>Unit tests to verify inheritance and Lombok decorations</li>
 * </ul>
 * 
 * <h2>Points of Interest MS2<h2>
 * <ul>
 *  <li>JavaX Persistence Table and Column decorators to control SQL schema</li>
 *  <li>ShowtimeRepoTests include Create, Read (implicit in create), Update and Delete </li>
 *  <li>Transactional test decorator allows framework to control SQL transactions and allow for multiple in a single method</li>
 *  <li>Autowire decorator in test file configures dependency injection of MovieRepo class</li>
 *  <li>Lombok NoArgsConstructor decorator necessary for JPARepo</li>
 *  <li>SpringbootTest decorator necessary to implement DI via @Autowired</li> 
 * </ul>
 *
 * <h2>Points of Interest MS3<h2>
 * <ul>
 *  <li>Additional repo queries (find by movieId and auditoriumId)</li>
 *  <li>View models to pass only relevant data to controller </li>
 *  <li>Service interface implemented by Service class</li>
 *  <li>Controller actions return http status codes instead of raw exceptions</li>
 * </ul>
 * <h2>Points of Interest MS3<h2>
 * <ul>
 *   <li>Security declarations on controller to authorize requests</li>
 * </ul>
 */

package se452.group4.project.showtime;
