package se452.group4.project.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@SuperBuilder
@MappedSuperclass
public class Entity {
    @Id
    @NonNull
    @Column(columnDefinition="uuid")
    private UUID id;
    
    @NonNull
    @Column(name = "created")
    private LocalDateTime created;

    protected Entity() {
        id = UUID.randomUUID();
        created = LocalDateTime.now();
    }
}
