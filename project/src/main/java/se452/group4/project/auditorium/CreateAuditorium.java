package se452.group4.project.auditorium;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor

public class CreateAuditorium {

    @NonNull
    private String name;
    
    private int capacity;
    
}
