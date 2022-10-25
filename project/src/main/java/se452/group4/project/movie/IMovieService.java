package se452.group4.project.movie;

import java.util.List;
import java.util.UUID;

public interface IMovieService {
    List<Movie> GetAllMovies();
    Movie CreateMovie(String title, String description, int length);
    Movie GetMovieById(UUID id);
    List<Movie> GetMovieByTitle(String title);
    Movie UpdateMovie(Movie movieToUpdate);
    void DeleteMovie(Movie movieToDelete);    
}
