package se452.group4.project.showtime;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IShowtimeService {
    List<Showtime> getAllShowtimes();
    Showtime createShowtime(UUID movieId, UUID auditoriumId, LocalDateTime showtime);
    Showtime getShowtimeById(UUID id);
    List<Showtime> getShowtimesByMovie(UUID movieId);
    List<Showtime> getShowtimesByAuditorium(UUID auditoriumId);
    Showtime updateShowtime(Showtime showtimeToUpdate);
    void deleteShowtime(Showtime showtimeToDelete);    
}
