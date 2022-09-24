package se452.group4.project.admin;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, UUID> {
    
}
