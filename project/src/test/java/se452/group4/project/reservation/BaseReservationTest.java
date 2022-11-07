package se452.group4.project.reservation;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseReservationTest {

    protected Reservation createReservation() {
        var r = Reservation.builder()
            .id(UUID.randomUUID())
            .created(LocalDateTime.now())
            .description("UnitTestDescription")
            .startTime(LocalDateTime.now().plusHours(5))
            .customerId(UUID.randomUUID())
            .showTimeId(UUID.randomUUID())
            .build();


        return r;
    }
}
