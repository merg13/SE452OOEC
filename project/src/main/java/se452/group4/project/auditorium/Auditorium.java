package se452.group4.project.auditorium;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Auditorium extends Entity {
    @NonNull
    private String name;
    private int capacity;
}