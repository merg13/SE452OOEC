package se452.group4.project.showtime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;

@Data
@javax.persistence.Entity
@Table(name = "showtimes")
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Showtime extends Entity {
    @NonNull
    @Column(name = "movie_id")
    private UUID movieId;
    
    @NonNull
    @Column(name = "auditorium_id")
    private UUID auditoriumId;
    
    @NonNull
    @Column(name = "showtime")
    private LocalDateTime time;     
}
