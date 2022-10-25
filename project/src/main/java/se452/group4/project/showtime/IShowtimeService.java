package se452.group4.project.showtime;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IShowtimeService {
    List<Showtime> GetAllShowtimes();
    Showtime CreateShowtime(UUID movieId, UUID auditoriumId, LocalDateTime showtime);
    Showtime GetShowtimeById(UUID id);
    List<Showtime> GetShowtimesByMovie(UUID movieId);
    List<Showtime> GetShowtimesByAuditorium(UUID auditoriumId);
    Showtime UpdateShowtime(Showtime showtimeToUpdate);
    void DeleteShowtime(Showtime showtimeToDelete);    
}
