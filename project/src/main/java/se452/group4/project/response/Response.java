package se452.group4.project.response;

import java.util.Set;

import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder()
public abstract class Response {
    public boolean success;
    public Set<String> errors;
}
