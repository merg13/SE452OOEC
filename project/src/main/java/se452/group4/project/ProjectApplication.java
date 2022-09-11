package se452.group4.project;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import se452.group4.project.reservation.Reservation;
import se452.group4.project.customer.Customer;
import se452.group4.project.movie.Movie;

@SpringBootApplication
public class ProjectApplication {

	private String[] groupMembers = new String[] { "Eric", "Tan", "Hani", "Mitchell" };

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	 }

	 @Bean
	 public void runIt() {
		
		System.out.println("-------Reservation-------");
		var reservation = new Reservation();
		reservation.setId(UUID.randomUUID());
		reservation.showTimeId = UUID.randomUUID();
		reservation.customerId = UUID.randomUUID();
		reservation.startTime = LocalDateTime.now();
		reservation.description = "Some important Description of a reservation for a movie.";
		System.out.println(reservation.toString());

		System.out.println("-------Customer-------");
		Customer customer = new Customer();
		customer.setName("Tan");
		System.out.println(customer.toString());

		System.out.println("-------Movie-------");
		Movie sampleMovie = new Movie("Exciting Movie 4", "This is what the movie is about. It's really cool!", 180);
		System.out.println(sampleMovie.toString());
	 }

}
