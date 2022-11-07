package se452.group4.project.admin;

import lombok.Data;

import org.springframework.data.redis.core.RedisHash;

import se452.group4.project.entity.Entity;

@Data
@RedisHash("Admin")
public class Admin extends Entity {
}