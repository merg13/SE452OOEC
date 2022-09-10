package se452.group4.project.reservation;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class Reservation {
    public UUID id;
    public String description;
    public LocalDateTime startTime;
    public UUID showTimeId;
    public UUID customerId;
}
