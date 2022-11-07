package se452.group4.project.reservation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@RedisHash
@Data
@EqualsAndHashCode()
@AllArgsConstructor
@ToString()
@SuperBuilder
public class Reservation implements Serializable {

    @NonNull
    @Indexed
    private UUID id;

    @NonNull
    @Indexed
    private LocalDateTime created;
    
    @Indexed
    public String description;
    
    @NonNull
    @Indexed
    public LocalDateTime startTime;
    
    @NonNull
    @Indexed
    public UUID showTimeId;
    
    @NonNull
    @Indexed
    public UUID customerId;

    public Reservation() {
        this.id = UUID.randomUUID();
        this.created = LocalDateTime.now();
    }
}