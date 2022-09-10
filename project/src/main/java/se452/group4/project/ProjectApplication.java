package se452.group4.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import se452.group4.project.models.Student;

@SpringBootApplication
public class ProjectApplication {

	private String[] groupMembers = new String[] { "Eric", "Tan", "Hani", "Mitchell" };

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	 }

	 @Bean
	 public void runIt() {
		System.out.println("-------");

		for (String g : groupMembers) {
			var s = new Student();
			s.setName(g);
			System.out.println(s.toString());
		}

		System.out.println("-------");
	 }

}
