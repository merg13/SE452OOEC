package se452.group4.project.movie;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;

@Data
@javax.persistence.Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "movies")
public class Movie extends Entity {
    @NonNull
    @Column(name = "title")
    private String title;
    
    @NonNull
    @Column(name = "description")
    private String description;
    
    @Column(name = "length")
    private int durationInMinutes;
}
