package se452.group4.project.auditorium;


import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepo extends JpaRepository<Auditorium, UUID>{
    
}
