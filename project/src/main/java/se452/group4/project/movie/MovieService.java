package se452.group4.project.movie;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieRepo _repo;

    @Override
    public Movie CreateMovie(String title, String description, int length) {
        return _repo.save(new Movie(title, description, length));
    }

    @Override
    public Movie GetMovieById(UUID id) {
        return _repo.findById(id).get();
    }

    @Override
    public List<Movie> GetMovieByTitle(String title) {
        return _repo.findByTitle(title);
    }

    @Override
    public Movie UpdateMovie(Movie movieToUpdate) {
        return _repo.save(movieToUpdate);
    }

    @Override
    public void DeleteMovie(Movie movieToDelete) {
        _repo.delete(movieToDelete);
    }

    @Override
    public List<Movie> GetAllMovies() {
        return _repo.findAll();
    }
    
}
