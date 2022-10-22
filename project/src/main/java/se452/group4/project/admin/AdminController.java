package se452.group4.project.admin;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

/**
 * The REST API Controller for Admin CRUD Services for FlixNet. 
 */
@RestController
@RequestMapping("/api/admin")
@Log4j2 
public class AdminController {
    @Autowired
    protected AdminService service;

    /**
     * Retrieves a Admin object based on an id in the FlixNet Database.
     * @param id
     * @return
     * @throws AdminException
     */
    @GetMapping("/{id}")
    public Admin get(@PathVariable("id") UUID id) throws AdminException {
        log.traceEntry("ENTER: get Admin by id.");
        try {
            var admin = service.GetAdminById(id);
            log.traceExit("EXIT: get Admin by id.");
            return admin;
        }
        catch(AdminException e) {
            throw e;
        }
    }

    /**
     * Saves a Admin object to the FlixNet Database.
     * @param Admin
     * @return Admin
     */
    @PostMapping
    public Admin save(@RequestBody Admin admin) throws AdminException {
        log.traceEntry("ENTER: save Admin.", admin);
        try {
            service.CreateAdmin(admin);
            log.traceExit("EXIT: save Admin.", admin);
            return admin;
        }
        catch(AdminException e) {
            throw e;
        }

    }


    /**
     * Upserts a Admin object in the FlixNet Database (Create if doesn't exist / update if id is present).
     * @param id
     * @param Admin
     * @return
     */
    @PutMapping()
    public Admin upsert(@RequestBody Admin admin) throws AdminException {
        log.traceEntry("ENTER: upsert Admin.", admin);
        try {
            var c = service.UpsertAdmin(admin);
            log.traceExit("EXIT: upsert Admin.", admin);
            return c;
        }
        catch(AdminException e) {
            throw e;
        }
    }

    /**
     * Deletes a Admin object from the FlixNet Database.
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) throws AdminException {
        log.traceEntry("ENTER: delete Admin.", id);
        try {
            service.DeleteAdminById(id);
            log.traceExit("EXIT: delete Admin.", id);
        }
        catch(AdminException e) {
            throw e;
        }
    }
}
