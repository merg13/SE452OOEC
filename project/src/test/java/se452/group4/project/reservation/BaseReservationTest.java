package se452.group4.project.reservation;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseReservationTest {

    protected Reservation createReservation() {
        var r = new Reservation();
        r.setId(UUID.randomUUID());
        r.setCreated(LocalDateTime.now());
        r.setDescription("UnitTestDescription");
        r.setStartTime(LocalDateTime.now().plusHours(5));
        r.setCustomerId(UUID.randomUUID());
        r.setShowTimeId(UUID.randomUUID());

        return r;
    }
}
