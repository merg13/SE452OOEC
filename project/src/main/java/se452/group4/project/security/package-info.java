/**
 * This package holds all functionality related to security implemented for FlixNet.
 * @version 0.0.1
 * @author Mitchell Ergen
 * 
 * <h1>Package Overview</h1>
 * 
 * <ul>
 *  <li><em>InMemory User Authentication</em> - utilizes extension methods on the UserDetailsService to provide a for DEVELOPMENT-ONLY user for auth to FlixNet.</li>
 *  <li><em>JPARepository Tables</em> - Users, User_Roles, Users_Roles</li>
 *  <li><em>UserRepository</em> - used to look up and perform CRUD operations on User. findByUsername(String username) && existsByUsername(String username) also.</li>
 *  <li><em>UserRoleRepository</em> - used to look up and perform CRUD operations on UserRole. findByName(String role) also.</li>
 *  <li><em>SecurityConfiguration</em> - filters http routes sent to FlixNet server and determines what should and shouldn't require authorization.</li>
 *  <li><em>Provides pre-authorization policies</em> based on the UserRoleType enum for use Securing FlixNet API Endpoints. (Examples: @Secured("ROLE_CUSTOMER", "ROLE_ADMIN")</li>
 *  <li><em>User Roles</em> are seeded in the H2 Database via the standard data.sql mechanism, as well as, a super user "testUser1" for DEVELOPMENT USE ONLY.</li>
 * </ul>
 * 
 *  
 */
package se452.group4.project.security;
