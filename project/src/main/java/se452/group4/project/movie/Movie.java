package se452.group4.project.movie;

import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;

@Data
@javax.persistence.Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Movie extends Entity {
    @NonNull
    private String title;
    @NonNull
    private String description;
    private int durationInMinutes;
}
