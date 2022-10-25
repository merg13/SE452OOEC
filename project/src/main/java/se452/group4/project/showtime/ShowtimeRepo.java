package se452.group4.project.showtime;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepo extends JpaRepository<Showtime, UUID> {
    List<Showtime> findByAuditoriumId(UUID auditoriumId); 
    List<Showtime> findByMovieId(UUID movieId);
}
