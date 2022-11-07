package se452.group4.project.security.user;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import se452.group4.project.response.Response;

@Data
@SuperBuilder
public class UserResponse extends Response {
    public User user;
}
