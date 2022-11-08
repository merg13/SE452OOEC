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
    public Auditorium CreateAuditorium(Auditorium newAuditorium) throws AuditoriumException {
        Auditorium auditorium = null;
        try {
            auditorium = repo.save(newAuditorium);
        } catch (Exception e) {
            throw new AuditoriumException(AuditoriumException.CreateAuditoriumError, e);
        }

        return auditorium;
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
