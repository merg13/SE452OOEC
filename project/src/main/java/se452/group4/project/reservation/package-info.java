/**
 * This package holds all functionality related to reservations for FlixNet.
 * @version 0.0.1
 * @author Mitchell Ergen
 * 
 * <h1>Package Overview</h1>
 * 
 * <p>Reservation is an entity that extends the abstract se452.group4.project.entity.Entity base class.</p>
 * 
 *  <h2>LOMBOK Usage</h2>
 * <ul>
 *  <li>@Data - Generates getters/setters for the properties on the object.</li>
 *  <li>@AllArgsConstructor - Generates a Standard constructor that includes parameters for each property on the object.</li>
 *  <li>@EqualsAndHashCode(callSuper = true) - Standard Equals and HashCode methods based on the object structure and its properties.</li>
 *  <li>@ToString(callSuper = true) - Since Reservation Extends the abstract Entity class, the <em>callSuper=true</em> allows the ToString method to also display the base class properties.</li>
 *  <li>@Entity - specifies that the annotaed model is an Entity for use in persistence through java persistence, the ReservationRepository, which extends the JPARepository for CRUD operations to the Database.
 * </ul>
 * 
 * <h2>JPARepository</h2>
 * <p>Through the ReservationRepository, The Reservation Entity interacts with a database using the repository pattern extending a JPARepository.</p>
 */
package se452.group4.project.reservation;
