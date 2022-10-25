package se452.group4.project.auditorium;

import java.util.List;
import java.util.UUID;


public interface IAuditoriumService {

  
    public List<Auditorium> GetAllCapacity() throws AuditoriumException;

    public Auditorium GetAuditorium(UUID id) throws AuditoriumException;

    public Auditorium CreateAuditorium(String name, int capacity) throws AuditoriumException;

    public Auditorium UpdateAuditorium(Auditorium auditorium) throws AuditoriumException;

    public void DeleteAuditorium(Auditorium delete) throws AuditoriumException;



}
