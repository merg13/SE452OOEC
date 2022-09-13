package se452.group4.project.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import se452.group4.project.entity.Entity;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Customer extends Entity {
    @NonNull
    public String name;
}

