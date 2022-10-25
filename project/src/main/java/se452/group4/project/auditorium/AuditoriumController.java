package se452.group4.project.auditorium;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("/api/auditorium")

public class AuditoriumController {


    @Autowired
    private AuditoriumService _service;


    @GetMapping
    public Auditorium get(@RequestParam(value = "id") UUID id) throws ResponseStatusException {
        try {
            Auditorium _m = _service.GetAuditorium(id);
            if (_m == null)
                throw new AuditoriumException();
            return _m;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping
    public void delete(@RequestParam(value = "id") UUID id) throws ResponseStatusException {
        try {
            Auditorium _m = _service.GetAuditorium(id);
            if (_m == null)
                throw new AuditoriumException();
            
            _service.DeleteAuditorium(_m);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/new")
    public Auditorium create(@RequestBody CreateAuditorium Auditorium) throws ResponseStatusException {
        try {
            return _service.CreateAuditorium(Auditorium.getName(), Auditorium.getCapacity());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PatchMapping("/update")
    public Auditorium update(@RequestBody UpdateAuditorium Auditorium) throws ResponseStatusException {
        try {
            Auditorium _m = _service.GetAuditorium(Auditorium.getId());
            if (_m == null)
                throw new AuditoriumException();

            if (Auditorium.getName() != null)
                _m.setName(Auditorium.getName());
            if (Auditorium.getCapacity() != null)
                _m.setCapacity(0);

            return _service.UpdateAuditorium(_m);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}