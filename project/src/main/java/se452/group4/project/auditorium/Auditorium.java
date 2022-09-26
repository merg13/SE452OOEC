package se452.group4.project.auditorium;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;
import javax.persistence.Table;

@Data
@javax.persistence.Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "auditorium")
@ToString(callSuper = true)


public class Auditorium extends Entity {
    
    public String name;
    public int capacity;

    public Auditorium() {}

}
