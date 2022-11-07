package se452.group4.project.reservation;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import se452.group4.project.response.Response;

@Data
@SuperBuilder
public class ReservationResponse extends Response {
    Iterable<Reservation> reservations;
}
