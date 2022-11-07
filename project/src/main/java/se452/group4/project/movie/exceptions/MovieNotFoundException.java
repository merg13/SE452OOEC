package se452.group4.project.movie.exceptions;

import java.util.UUID;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException(UUID id) {
        super(String.format("Unable to locate movie with ID: %s", id.toString()));
    }
}
