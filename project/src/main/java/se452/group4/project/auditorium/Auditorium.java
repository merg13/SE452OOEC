package se452.group4.project.auditorium;

import lombok.Data;

import se452.group4.project.entity.Entity;

import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@RedisHash("Auditorium")
public class Auditorium extends Entity {
    
    public String name;
    public int capacity;
}
