package se452.group4.project.auditorium;


import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuditoriumRepo extends JpaRepository<Auditorium, UUID>{

    /**
     * finds all the Auditorium based on capacity.
     * @param capacity
     */
    public List<Auditorium> findByCapacity(int capacity);
    

    /**
     * finds all the Auditoriums based on name.
     * @param name
     */
    public List<Auditorium> findByName(String name);
    
}
