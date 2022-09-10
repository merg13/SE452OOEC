package se452.group4.project.entity;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public abstract class Entity {
    @NonNull
    private UUID id;
    @NonNull
    private LocalDateTime created;

    protected Entity() {
        id = UUID.randomUUID();
        created = LocalDateTime.now();
    }
}
