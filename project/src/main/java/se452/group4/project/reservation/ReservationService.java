package se452.group4.project.reservation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {
    @Autowired 
    ReservationRepo repo; 

    public List<Reservation> GetAllReservations() throws ReservationException {
        List<Reservation> retval = null;

        try {
            retval = repo.findAll();
        } catch (Exception e) {
            throw new ReservationException(ReservationException.GetAllReservationsError, e);
        }
        return retval;
    }

    public Reservation GetReservationById(UUID id) throws ReservationException {
        Reservation retval = null;
        try {
            retval = repo.findById(id).get();
        } catch (Exception e) {
            throw new ReservationException(id, ReservationException.GetReservationByIdError, e);
        }

        return retval;
    }

    public Reservation UpsertReservation(Reservation newReservation) throws ReservationException {
        Reservation retval = null;
        var newId = newReservation.getId();
        try {
            if (!repo.existsById(newId)) {
                retval = repo.save(newReservation);
                return retval;
            }   

            // Update fields that are updateable... shouldn't allow initial ID or Created Timestamp to be udpated.
            retval = repo.findById(newId).get();
            retval.setCustomerId(newReservation.customerId);
            retval.setDescription(newReservation.description);
            retval.setShowTimeId(newReservation.showTimeId);

            retval = repo.save(retval);
        } catch (Exception e) {
            throw new ReservationException(newId, ReservationException.UpsertReservationError, e);
        }

        return retval;
    }

    public Reservation CreateReservation(Reservation newReservation) throws ReservationException {
        Reservation retval = null;
        try {
            retval = repo.save(newReservation);

        } catch (Exception e) {
            throw new ReservationException(ReservationException.CreateReservationError, e);
        }

        return retval;
    }

    public void DeleteReservationById(UUID id) throws ReservationException {
        try {
            repo.delete(repo.findById(id).get());
        } catch (Exception e) {
            throw new ReservationException(id, ReservationException.DeleteReservationByIdError, e);
        }
    }
}
