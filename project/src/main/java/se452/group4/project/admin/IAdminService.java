package se452.group4.project.admin;

import java.util.UUID;

/**
 * Interface for interacting with the Repository Layer an Admin Objects in the DB.
 */
public interface IAdminService {

    /**
     * Gets a Admin based on a Unique Identifier for it.
     * @param id
     * @return
     * @throws AdminException
     */
    public Admin GetAdminById(UUID id) throws AdminException;

    /**
     * Upserts a Admin object based on the new data structure. Create/Insert or Update.
     * @param id
     * @param newAdmin
     * @return
     */
    public Admin UpsertAdmin(Admin newAdmin) throws AdminException;

    /**
     * Creates a new Admin object.
     * @param newAdmin
     * @return
     */
    public Admin CreateAdmin(Admin newAdmin) throws AdminException;

    /**
     * Deletes a Admin based on a given unique identifier for it.
     * @param id
     */
    public void DeleteAdminById(UUID id) throws AdminException;
}
