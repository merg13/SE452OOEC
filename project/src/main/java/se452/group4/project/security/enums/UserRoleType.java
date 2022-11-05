package se452.group4.project.security.enums;

/**
 * Enum for User Roles in the FlixNet System. NOTE: There is not currently an automated method setup for syncing these with the H2 DB... 
 * If you add or changes values here make sure you:
 * (1) update, all security attributes using them.
 * (2) update the data.sql seed data with the changes. 
 */
public enum UserRoleType {
    ROLE_CUSTOMER,
    ROLE_ADMIN;
}
