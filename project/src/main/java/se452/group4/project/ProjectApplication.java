package se452.group4.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import se452.group4.project.models.Student;
import se452.group4.project.customer.Customer;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	 }

	 @Bean
	 public void runIt() {
		System.out.println("-------Student-------");
		Student student = new Student();
		student.setName("Mitchell");
		System.out.println(student.toString());
		System.out.println("-------Customer-------");
		Customer customer = new Customer();
		customer.setName("Tan");
		System.out.println(customer.toString());
	 }

}
