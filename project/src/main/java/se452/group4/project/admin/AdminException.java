package se452.group4.project.admin;

import java.util.UUID;

public class AdminException extends Exception {
    public static String GetAdminByIdError = "ERROR: GetAdminByIdError: could not successfully get AdminById: ";
    public static String UpsertAdminError = "ERROR: UpsertAdminError: could not successfully upsert AdminById: ";
    public static String CreateAdminError = "ERROR: CreateAdminError: could not successfully create Admin.";
    public static String DeleteAdminByIdError = "ERROR: DeleteAdminByIdError: could not successfully delete AdminById: ";

    public AdminException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
    
    public AdminException(UUID id, String errorMessage, Throwable cause) {
        super(errorMessage + id.toString(), cause);
    }

    public AdminException() {
    }
}
