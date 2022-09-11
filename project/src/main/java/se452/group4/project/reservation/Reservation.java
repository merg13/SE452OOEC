package se452.group4.project.reservation;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import se452.group4.project.entity.Entity;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Reservation extends Entity {
    public String description;
    public LocalDateTime startTime;
    public UUID showTimeId;
    public UUID customerId;

    public Reservation() {}
}
