package se452.group4.project.auditorium;



import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor

public class UpdateAuditorium {

    @NonNull
    private UUID id;

    private String name;
    
    private int capacity;

}

