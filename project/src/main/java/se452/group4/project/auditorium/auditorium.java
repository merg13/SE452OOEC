package se452.group4.project.auditorium;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import se452.group4.project.entity.Entity;

public class auditorium extends Entity{

    public UUID showTimeId;
    public UUID customerId;
    private String auditorium_name;
    private int capacity;
    private int seat_number;
}