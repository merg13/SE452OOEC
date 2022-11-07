package se452.group4.project.admin;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, UUID> {
    
}
