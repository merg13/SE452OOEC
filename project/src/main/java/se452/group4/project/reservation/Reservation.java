package se452.group4.project.reservation;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;

@Data
@javax.persistence.Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Reservation extends Entity {

    @Column(name = "description")
    public String description;

    @NonNull
    @Column(name = "start_time")
    public LocalDateTime startTime;

    @NonNull
    @Column(name = "showtime_id")
    public UUID showTimeId;

    @NonNull
    @Column(name = "customer_id")
    public UUID customerId;

    public Reservation() {}
}
