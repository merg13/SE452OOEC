package se452.group4.project.admin;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.redis.core.RedisHash;

import se452.group4.project.entity.Entity;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RedisHash("Admin")
public class Admin extends Entity {
}