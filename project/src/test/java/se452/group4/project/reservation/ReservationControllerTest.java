// package se452.group4.project.reservation;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;

// import org.aspectj.lang.annotation.Before;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.security.test.context.support.WithMockUser;
// import org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener;
// import org.springframework.security.test.context.support.WithUserDetails;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.TestExecutionListeners;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
// import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
// import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
// import org.springframework.test.context.web.ServletTestExecutionListener;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.web.context.WebApplicationContext;


// TODO: Fix these tests now that endpoints are security by Roles... some mocking lib needs to be configured.
// @WebMvcTest(ReservationController.class)
// @ContextConfiguration
// @TestExecutionListeners(listeners={
// 		WithSecurityContextTestExecutionListener.class})
// public class ReservationControllerTest extends BaseReservationTest {
    
//     @Autowired
//     ReservationController controller;

//     ReservationService service;

//     @Autowired
//     private WebApplicationContext context;

//     @Autowired
//     private MockMvc mvc;

//     public ReservationControllerTest() {
//         service = mock(ReservationService.class);
//     }

//     @Test
//     @WithMockUser(username = "testUser1", roles = {"CUSTOMER"})
//     public void testGetAllReservations() throws ReservationException {
//         // Arrange
//         controller.service = service;
//         var list = new ArrayList<Reservation>();
//         list.add(new Reservation());
//         list.add(new Reservation());
        
//         when(service.GetAllReservations()).thenReturn(list);

//         // Act
//         var result = controller.list();

//         // Assert
//         assertNotNull(result);
//         assertEquals(2, result.size());
//     }

//     @WithUserDetails("testUser1")
//     @Test
//     public void testGetReservationById() throws ReservationException {
//         // Arrange
//         controller.service = service;
//         var r = createReservation();
//         when(service.GetReservationById(r.getId())).thenReturn(r);
//         // Act
//         var result = controller.get(r.getId());

//         // Assert
//         assertNotNull(result);
//         assertEquals(r, result);
//     }

//     @WithUserDetails("testUser1")
//     @Test
//     public void testUpsertReservation() throws ReservationException {
//         // Arrange
//         controller.service = service;
//         var r = createReservation();
//         when(service.UpsertReservation(r)).thenReturn(r);

//         // Act
//         var result = controller.upsert(r);

//         // Assert
//         assertNotNull(result);
//         assertEquals(r, result);
//     }

//     @WithUserDetails("testUser1")
//     @Test
//     public void testSaveNewReservation() throws ReservationException {
//         // Arrange
//         var r = createReservation();

//         // Act
//         var result = controller.save(r);
        
//         // Assert
//         assertNotNull(result);
//         assertEquals(r, result);
//     }

//     @WithUserDetails("testUser1")
//     @Test
//     public void testDeleteReservationById() throws ReservationException {
//         // Arrange
//         controller.service = service;
//         var r = createReservation();
//         controller.save(r);
        
//         // Act
//         controller.delete(r.getId());
//         var result = controller.list();

//         // Assert
//         assertNotNull(result);
//         assertEquals(0, result.size());
//     }
// }
