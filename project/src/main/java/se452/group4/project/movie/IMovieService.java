package se452.group4.project.movie;

import java.util.List;
import java.util.UUID;

public interface IMovieService {
    List<Movie> getAllMovies();
    Movie createMovie(String title, String description, int length);
    Movie getMovieById(UUID id);
    List<Movie> getMovieByTitle(String title);
    Movie updateMovie(Movie movieToUpdate);
    void deleteMovie(Movie movieToDelete);    
}
