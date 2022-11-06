package se452.group4.project.showtime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShowtimeServiceTest {
    @Autowired
    private ShowtimeService _service;

    private ShowtimeRepo _repo;

    public ShowtimeServiceTest() {
        _repo = mock(ShowtimeRepo.class);
    }

    @AfterEach 
    private void dispose(){
        _repo.deleteAll();
    }

    @DisplayName("Test ShowtimeService create method")
    @Test
    public void  testShowtimeServiceCreateShowtime() {
        UUID movieId = UUID.randomUUID();
        UUID auditoriumId = UUID.randomUUID();
        LocalDateTime time = LocalDateTime.now();

        _service._repo = _repo;
        when(_repo.save(any(Showtime.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        Showtime _s = _service.createShowtime(movieId, auditoriumId, time);
        
        assertNotNull(_s);
        assertEquals(_s.getMovieId(), movieId);
        assertEquals(_s.getAuditoriumId(), auditoriumId);
        assertEquals(_s.getTime(), time);
    }

    @DisplayName("Test ShowtimeService update method")
    @Test
    public void  testShowtimeServiceUpdateShowtime() {
        UUID movieId = UUID.randomUUID();
        UUID oldAuditoriumId = UUID.randomUUID();
        LocalDateTime time = LocalDateTime.now();
        Showtime _s = new Showtime(movieId, oldAuditoriumId, time);
        UUID _id = _s.getId();
        
        _service._repo = _repo;

        when(_repo.save(_s)).thenReturn(_s);

        UUID newAudId = UUID.randomUUID();
        _s.setAuditoriumId(newAudId);
        Showtime _updated = _service.updateShowtime(_s);

        assertNotNull(_updated);
        assertEquals(_updated.getId(), _id);
        assertEquals(_updated.getMovieId(), movieId);
        assertEquals(_updated.getAuditoriumId(), newAudId);
        assertEquals(_updated.getTime(), time);
    }

    @DisplayName("Test ShowtimeService getById method")
    @Test
    public void  testShowtimeServiceGetById() {
        UUID movieId = UUID.randomUUID();
        UUID auditoriumId = UUID.randomUUID();
        LocalDateTime time = LocalDateTime.now();
        Showtime _s = new Showtime(movieId, auditoriumId, time);
        UUID id = _s.getId();

        _service._repo = _repo;
        when(_repo.findById(id)).thenReturn(Optional.of(_s));
        Showtime _ret = _service.getShowtimeById(id);
        
        assertNotNull(_ret);
        assertEquals(_ret.getId(), id);
        assertEquals(_ret.getMovieId(), movieId);
        assertEquals(_ret.getAuditoriumId(), auditoriumId);
        assertEquals(_ret.getTime(), time);
    }
}
