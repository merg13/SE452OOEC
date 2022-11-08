package se452.group4.project.auditorium;

import lombok.Data;

import se452.group4.project.entity.Entity;

import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Admin")

public class Auditorium extends Entity {
    
    public String name;
    public int capacity;

    public Auditorium() {}

}
