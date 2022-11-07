package se452.group4.project.reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Class for interactions with the DAO for Reservation objects in the FlixNet System.
 */
@Service
public class ReservationService implements IReservationService {
    @Autowired 
    public ReservationRepository repo; 

    public ReservationResponse GetAllReservations() throws ReservationException {
        ReservationResponse retval;

        try {
            retval = ReservationResponse.builder()
                .reservations(repo.findAll())
                .errors(Set.of(new String[]{}))
                .success(true)
                .build();
        } catch (Exception e) { 
            retval = ReservationResponse.builder()
                .reservations(null)
                .success(false)
                .errors(Set.of(ReservationException.GetAllReservationsError))
                .build();
        }
        return retval;
    }

    public ReservationResponse GetReservationById(UUID id) throws ReservationException {
        ReservationResponse retval;
        try {
            retval = ReservationResponse.builder()
                .reservations(List.of(repo.findById(id).get()))
                .errors(Set.of(new String[]{}))
                .success(true)
                .build();
        } catch (Exception e) {
            retval = ReservationResponse.builder()
                .reservations(null)
                .errors(Set.of(ReservationException.GetReservationByIdError))
                .success(false)
                .build();
        }
        return retval;
    }

    public ReservationResponse UpsertReservation(Reservation newReservation) throws ReservationException {
        ReservationResponse retval;
        var newId = newReservation.getId();
        try {
            if (!repo.existsById(newId)) {
                retval = ReservationResponse.builder()
                    .reservations(List.of(repo.save(newReservation)))
                    .errors(Set.of(new String[]{}))
                    .success(true)
                    .build();

                return retval;
            }   

            // Update fields that are updateable... shouldn't allow initial ID or Created Timestamp to be udpated.
            var updateableReservation = repo.findById(newId).get();
            updateableReservation.setCustomerId(newReservation.customerId);
            updateableReservation.setDescription(newReservation.description);
            updateableReservation.setShowTimeId(newReservation.showTimeId);

            // Save  
            retval = ReservationResponse.builder()
                .reservations(List.of(repo.save(updateableReservation)))
                .success(true)
                .errors(Set.of(new String[]{}))
                .build();

        } catch (Exception e) {
            retval = ReservationResponse.builder()
                .reservations(null)
                .errors(Set.of(ReservationException.UpsertReservationError))
                .success(false)
                .build();
        }
        return retval;
    }

    public ReservationResponse CreateReservation(Reservation newReservation) throws ReservationException {
        ReservationResponse retval;
        try {
            retval = ReservationResponse.builder()
                .reservations(List.of(repo.save(newReservation)))
                .success(true)
                .errors(Set.of(new String[]{}))
                .build();

        } catch (Exception e) {
            retval = ReservationResponse.builder()
                .reservations(null)
                .errors(Set.of(ReservationException.CreateReservationError))
                .success(false)
                .build();
        }

        return retval;
    }

    public ReservationResponse DeleteReservationById(UUID id) throws ReservationException {
        ReservationResponse retval;
        try {
            repo.delete(repo.findById(id).get());

            retval = ReservationResponse.builder()
                .reservations(null)
                .success(true)
                .errors(Set.of(new String[]{}))
                .build();

        } catch (Exception e) {
            retval = ReservationResponse.builder()
                .reservations(null)
                .success(false)
                .errors(Set.of(new String[]{ReservationException.DeleteReservationByIdError}))
                .build();
        }

        return retval;
    }

    @Override
    public ReservationResponse GetReservationsBetweenStartTime(LocalDateTime firstDateTime,
            LocalDateTime secondDateTime) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReservationResponse GetReservationsByCustomerId(UUID customerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReservationResponse GetReservationsByDescription(String description) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ReservationResponse GetReservationsByShowTimeId(UUID showTimeId) {
        // TODO Auto-generated method stub
        return null;
    }
}
