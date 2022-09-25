package se452.group4.project.showtime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShowtimeRepoTest {
    @Autowired
    private ShowtimeRepo _repo;

    @DisplayName("Test ShowtimeRepo Create method")
    @Test
    public void testShowtimeRepoCreate() {
        // Number of records before add
        long currentRecords = _repo.count();
        
        _repo.save(createDummyShowtime());

        assertEquals(currentRecords + 1, _repo.count());
    }

    @DisplayName("Test ShowtimeRepo Update method")
    @Test
    @Transactional
    public void testShowtimeRepoUpdate() {        
        Showtime _s = createDummyShowtime();
        UUID id = _s.getId();
        _repo.save(_s);

        LocalDateTime newTime = LocalDateTime.now().plusDays(5);
        _s.setTime(newTime);
        _repo.save(_s);

        Showtime _u = _repo.getReferenceById(id);

        assertEquals(_u.getTime(), newTime);
    }

    @DisplayName("Test ShowtimeRepo Delete method")
    @Test
    @Transactional
    public void testShowtimeRepoDelete() {
        // Number of records before add
        long currentRecords = _repo.count();
        
        Showtime _s = createDummyShowtime();
        _repo.save(_s);            

        assertEquals(currentRecords + 1, _repo.count());

        _repo.delete(_s);
        
        assertEquals(currentRecords, _repo.count());
    }

    private Showtime createDummyShowtime() {
        return new Showtime(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now());
    }
}
