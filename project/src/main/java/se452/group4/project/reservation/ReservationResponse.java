package se452.group4.project.reservation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import se452.group4.project.response.Response;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder
public class ReservationResponse extends Response {
    Iterable<Reservation> reservations;
}
