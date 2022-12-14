package se452.group4.project.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import javax.persistence.Table;
import javax.persistence.Column;
import se452.group4.project.entity.Entity;


@Data
@javax.persistence.Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(name = "customer")
public class Customer extends Entity {
    @NonNull
    @Column(name = "name")
    public String name;

    public Customer() {}
}

