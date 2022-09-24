package se452.group4.project.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class Entity {
    @Id
    @NonNull
    @Column(length = 16)
    private UUID id;
    
    @NonNull
    @Column(name = "created")
    private LocalDateTime created;

    protected Entity() {
        id = UUID.randomUUID();
        created = LocalDateTime.now();
    }
}
