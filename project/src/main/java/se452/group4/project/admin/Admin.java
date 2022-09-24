package se452.group4.project.admin;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.ToString;
import javax.persistence.Table;

import se452.group4.project.entity.Entity;

@Data
@javax.persistence.Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "admin")
public class Admin extends Entity {
}
