package se452.group4.project.movie;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, UUID> {
    
    /**
     * finds all the Movies based on an exact title.
     * @param title
     * @return Movie
     */
    List<Movie> findByTitle(String title);

}
