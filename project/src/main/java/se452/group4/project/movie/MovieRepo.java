package se452.group4.project.movie;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, UUID> {
    
}
