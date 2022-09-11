package se452.group4.project.showtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Showtime extends Entity {
    @NonNull
    private UUID movieId;
    @NonNull
    private UUID auditoriumId;
    @NonNull
    private LocalDateTime time;     
}
