package se452.group4.project.entity;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class Entity {
    @Id
    @NonNull
    private UUID id;
    
    @NonNull
    private LocalDateTime created;

    protected Entity() {
        id = UUID.randomUUID();
        created = LocalDateTime.now();
    }
}
