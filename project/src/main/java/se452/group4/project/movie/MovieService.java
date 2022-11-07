package se452.group4.project.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepo _repo;

    @Override
    public Movie createMovie(String title, String description, int length) {
        return _repo.save(new Movie(title, description, length));
    }

    @Override
    public Movie getMovieById(UUID id) {
        return _repo.findById(id).get();
    }

    @Override
    public List<Movie> getMovieByTitle(String title) {
        return _repo.findByTitle(title);
    }

    @Override
    public Movie updateMovie(Movie movieToUpdate) {
        return _repo.save(movieToUpdate);
    }

    @Override
    public void deleteMovie(Movie movieToDelete) {
        _repo.delete(movieToDelete);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> ret = new ArrayList<Movie>();

        Iterable<Movie> allMovies = _repo.findAll();
        allMovies.forEach(ret::add);
        return ret;
    }
    
}
