package se452.group4.project.security.userRole;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import se452.group4.project.security.enums.UserRoleType;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByName(UserRoleType name);
}
