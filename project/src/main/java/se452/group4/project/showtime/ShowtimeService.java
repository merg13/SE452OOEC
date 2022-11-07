package se452.group4.project.showtime;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowtimeService implements IShowtimeService {
    @Autowired
    ShowtimeRepo _repo;

    @Override
    public List<Showtime> getAllShowtimes() {
        return _repo.findAll();
    }

    @Override
    public Showtime createShowtime(UUID movieId, UUID auditoriumId, LocalDateTime showtime) {
        return _repo.save(new Showtime(movieId, auditoriumId, showtime));
    }

    @Override
    public Showtime getShowtimeById(UUID id) {
        return _repo.findById(id).get();
    }

    @Override
    public List<Showtime> getShowtimesByMovie(UUID movieId) {
        return _repo.findByMovieId(movieId);
    }

    @Override
    public List<Showtime> getShowtimesByAuditorium(UUID auditoriumId) {
        return _repo.findByAuditoriumId(auditoriumId);
    }

    @Override
    public Showtime updateShowtime(Showtime showtimeToUpdate) {
        return _repo.save(showtimeToUpdate);
    }

    @Override
    public void deleteShowtime(Showtime showtimeToDelete) {
        _repo.delete(showtimeToDelete);
    }
    
}
