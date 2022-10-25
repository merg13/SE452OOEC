package se452.group4.project.auditorium;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuditoriumService implements IAuditoriumService {

    @Autowired 
    AuditoriumRepo repo; 
    
    public AuditoriumService(AuditoriumRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Auditorium> GetAllCapacity() throws AuditoriumException {
        return null;
    }

    @Override
    public Auditorium GetAuditorium(UUID id) throws AuditoriumException {
        return repo.findById(id).get();
    }

    @Override
    public Auditorium CreateAuditorium(String name, int capacity) throws AuditoriumException {
        return repo.save(new Auditorium(name, capacity));
    }

    @Override
    public Auditorium UpdateAuditorium(Auditorium auditorium) throws AuditoriumException {
        return repo.save(auditorium);
    }

    @Override
    public void DeleteAuditorium(Auditorium delete) throws AuditoriumException {
        repo.delete(delete);
    }

    
}
