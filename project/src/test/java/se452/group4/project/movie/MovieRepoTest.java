package se452.group4.project.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import javax.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieRepoTest {
    // Dependency injection 
    @Autowired
    private MovieRepo _repo;
    
    @DisplayName("Test MovieRepo Create method")
    @Test
    public void testMovieRepoCreate() {
        // Number of records before add
        long currentRecords = _repo.count();
        
        _repo.save(createDummyMovie());

        assertEquals(currentRecords + 1, _repo.count());
    }

    @DisplayName("Test MovieRepo Update method")
    @Test
    @Transactional
    public void testMovieRepoUpdate() {        
        Movie _m = createDummyMovie();
        UUID id = _m.getId();
        _repo.save(_m);

        String newTitle = "A new cooler title...";
        _m.setTitle(newTitle);
        _repo.save(_m);

        Movie _u = _repo.getReferenceById(id);

        assertEquals(_u.getTitle(), newTitle);
    }

    @DisplayName("Test MovieRepo Delete method")
    @Test
    public void testMovieRepoDelete() {
        // Number of records before add
        long currentRecords = _repo.count();
        
        Movie _m = createDummyMovie();
        _repo.save(_m);            

        assertEquals(currentRecords + 1, _repo.count());

        _repo.delete(_m);

        assertEquals(currentRecords, _repo.count());
    }

    private Movie createDummyMovie() {
        return new Movie("MovieTitle1", "MovieDescription2", 120);
    }
}
