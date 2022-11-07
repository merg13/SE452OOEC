package se452.group4.project.admin;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.ToString;
import javax.persistence.Table;

import se452.group4.project.entity.Entity;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash

public class Admin extends Entity {
}
