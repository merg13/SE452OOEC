package se452.group4.project.admin;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService {
    @Autowired 
    AdminRepo repo; 

    public Admin GetAdminById(UUID id) throws AdminException {
        Admin admin = null;
        try {
            admin = repo.findById(id).get();
        } catch (Exception e) {
            throw new AdminException(id, AdminException.GetAdminByIdError, e);
        }

        return admin;
    }

    public Admin UpsertAdmin(Admin newAdmin) throws AdminException {
        Admin admin = null;
        var newId = newAdmin.getId();
        try {
            if (!repo.existsById(newId)) {
                admin = repo.save(newAdmin);
                return admin;
            }   

            // Update fields that are updateable... shouldn't allow initial ID or Created Timestamp to be udpated.
            admin = repo.findById(newId).get();

            admin = repo.save(admin);
        } catch (Exception e) {
            throw new AdminException(newId, AdminException.UpsertAdminError, e);
        }

        return admin;
    }

    public Admin CreateAdmin(Admin newAdmin) throws AdminException {
        Admin admin = null;
        try {
            admin = repo.save(newAdmin);
        } catch (Exception e) {
            throw new AdminException(AdminException.CreateAdminError, e);
        }

        return admin;
    }

    public void DeleteAdminById(UUID id) throws AdminException {
        try {
            repo.delete(repo.findById(id).get());
        } catch (Exception e) {
            throw new AdminException(id, AdminException.DeleteAdminByIdError, e);
        }
    }
}
