package se452.group4.project.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService _service;

    private MovieRepo _repo;

    public MovieServiceTest() {
        _repo = mock(MovieRepo.class);
    }

    @AfterEach 
    private void dispose(){
        _repo.deleteAll();
    }

    @DisplayName("Test MovieService create method")
    @Test
    public void  testMovieServiceCreateMovie() {
        String title = "Test Movie";
        String description = "Test Description";
        int length = 99;

        _service._repo = _repo;
        when(_repo.save(any(Movie.class))).thenAnswer(AdditionalAnswers.returnsFirstArg());
        Movie _m = _service.createMovie(title, description, length);
        
        assertNotNull(_m);
        assertEquals(_m.getTitle(), title);
        assertEquals(_m.getDescription(), description);
        assertEquals(_m.getDurationInMinutes(), length);
    }

    @DisplayName("Test MovieService update method")
    @Test
    public void  testMovieServiceUpdateMovie() {
        String title = "Test Movie";
        String oldDescription = "Test Description";
        int length = 99;
        Movie _m = new Movie(title, oldDescription, length);
        UUID _id = _m.getId();
        
        _service._repo = _repo;

        when(_repo.save(_m)).thenReturn(_m);

        String newDescription = "New Description";
        _m.setDescription(newDescription);
        Movie _updated = _service.updateMovie(_m);

        assertNotNull(_updated);
        assertEquals(_updated.getId(), _id);
        assertEquals(_updated.getTitle(), title);
        assertEquals(_updated.getDescription(), newDescription);
        assertEquals(_updated.getDurationInMinutes(), length);
    }

    @DisplayName("Test MovieService getById method")
    @Test
    public void  testMovieServiceGetById() {
        String title = "Test Movie";
        String description = "Test Description";
        int length = 99;
        Movie _m = new Movie(title, description, length);
        UUID id = _m.getId();

        _service._repo = _repo;
        when(_repo.findById(id)).thenReturn(Optional.of(_m));
        Movie _ret = _service.getMovieById(id);
        
        assertNotNull(_ret);
        assertEquals(_ret.getId(), id);
        assertEquals(_ret.getTitle(), title);
        assertEquals(_ret.getDescription(), description);
        assertEquals(_ret.getDurationInMinutes(), length);
    }
}