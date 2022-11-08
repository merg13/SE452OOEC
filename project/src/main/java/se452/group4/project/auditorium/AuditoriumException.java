package se452.group4.project.auditorium;

import java.util.UUID;

public class AuditoriumException extends Exception {

    public static String GetAllShowtimeId = "ERROR: GetAllShowtimeId: could not successfully get all showtimeId.";
    public static String GetAllCapacity = "ERROR: GetAllCapacity: could not successfully get all CapacityId.";
    public static String GetShowtimeByIdError = "ERROR: GetShowtimeByIdError: could not successfully get all showtimeId.";
    public static String GetCapacityByIdError = "ERROR: GetCapacityByIdError: could not successfully get all showtimeId.";
    public static String CreateAuditoriumError = "ERROR: CreateAuditoriumError: could not successfully create Auditorium.";

    public AuditoriumException(String errorMessage, Throwable cause) {
        super();
    }


    public AuditoriumException(UUID id, String errorMessage, Throwable cause) {
        super();
    }
    

    public AuditoriumException() {
    }

}
