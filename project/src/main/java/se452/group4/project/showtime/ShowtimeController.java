package se452.group4.project.showtime;

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

import se452.group4.project.showtime.exceptions.ShowtimeNotFoundException;
import se452.group4.project.showtime.viewmodels.NewShowtimeVm;
import se452.group4.project.showtime.viewmodels.UpdateShowtimeVm;

@RestController
@RequestMapping("/api/showtime")
public class ShowtimeController {
    @Autowired
    private IShowtimeService _service;

    @GetMapping("/all")
    @PermitAll
    public List<Showtime> getAll() {
        return _service.getAllShowtimes();
    }

    @GetMapping()
    @PermitAll
    public Showtime get(@RequestParam(value = "id") UUID id) throws ResponseStatusException {
        try {
            Showtime _s = _service.getShowtimeById(id);
            if (_s == null)
                throw new ShowtimeNotFoundException(id);
            return _s;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
    
    @DeleteMapping
    @Secured({ "ROLE_ADMIN" })
    public void delete(@RequestParam(value = "id") UUID id) throws ResponseStatusException {
        try {
            Showtime _s = _service.getShowtimeById(id);
            if (_s == null)
                throw new ShowtimeNotFoundException(id);
            
            _service.deleteShowtime(_s);  
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/new")
    @Secured({ "ROLE_ADMIN" })
    public Showtime create(@RequestBody NewShowtimeVm showtime) throws ResponseStatusException {
        try {
            return _service.createShowtime(showtime.getMovieId(), showtime.getAuditoriumId(), showtime.getTime());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PatchMapping("/update")
    @Secured({ "ROLE_ADMIN" })
    public Showtime update(@RequestBody UpdateShowtimeVm showtime) throws ResponseStatusException {
        try {
            Showtime _s = _service.getShowtimeById(showtime.getId());
            if (_s == null)
                throw new ShowtimeNotFoundException(showtime.getId());

            if (showtime.getMovieId() != null)
                _s.setMovieId(showtime.getMovieId());
            if (showtime.getAuditoriumId() != null)
                _s.setAuditoriumId(showtime.getAuditoriumId());
            if (showtime.getTime() != null) 
                _s.setTime(showtime.getTime());
                
            return _service.updateShowtime(_s);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
