package se452.group4.project.showtime.exceptions;

import java.util.UUID;

public class ShowtimeNotFoundException extends Exception {
    public ShowtimeNotFoundException(UUID id) {
        super(String.format("Unable to locate showtime with ID: %s", id.toString()));
    }
}
