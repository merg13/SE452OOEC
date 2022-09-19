package se452.group4.project.showtime;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepo extends JpaRepository<Showtime, UUID> {
    
}
