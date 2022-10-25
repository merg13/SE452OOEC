package se452.group4.project.showtime.viewmodels;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class NewShowtimeVm {
    @NonNull
    private UUID movieId;
    
    @NonNull
    private UUID auditoriumId;
    
    @NonNull
    private LocalDateTime time;  
}
