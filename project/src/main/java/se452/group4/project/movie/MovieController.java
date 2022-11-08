package se452.group4.project.movie;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.log4j.Log4j2;
import se452.group4.project.movie.exceptions.MovieNotFoundException;
import se452.group4.project.movie.viewmodels.NewMovieVm;
import se452.group4.project.movie.viewmodels.UpdateMovieVm;

@RestController
@RequestMapping("/api/movie")
// @Log4j2
public class MovieController {
    @Autowired
    private MovieService _service;

    @PermitAll
    @GetMapping("/all")
    public List<Movie> getAll() {
      return _service.getAllMovies();
    }

    @PermitAll
    @GetMapping
    public Movie get(@RequestParam(value = "id") UUID id) throws ResponseStatusException {
        try {
            Movie _m = _service.getMovieById(id);
            if (_m == null)
                throw new MovieNotFoundException(id);
            return _m;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping
    @Secured({ "ROLE_ADMIN" })
    public void delete(@RequestParam(value = "id") UUID id) throws ResponseStatusException {
        try {
 
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/new")
    @Secured({ "ROLE_ADMIN" })
    public Movie create(@RequestBody NewMovieVm movie) throws ResponseStatusException {
        try {
            return _service.createMovie(movie.getTitle(), movie.getDescription(), movie.getDurationInMinutes());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PatchMapping("/update")
    @Secured({ "ROLE_ADMIN" })
    public Movie update(@RequestBody UpdateMovieVm movie) throws ResponseStatusException {
        try {
            Movie _m = _service.getMovieById(movie.getId());
            if (_m == null)
                throw new MovieNotFoundException(movie.getId());

            if (movie.getTitle() != null)
                _m.setTitle(movie.getTitle());
            if (movie.getDescription() != null)
                _m.setDescription(movie.getDescription());
            if (movie.getDurationInMinutes() != null)
                _m.setDurationInMinutes(movie.getDurationInMinutes());

            return _service.updateMovie(_m);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
