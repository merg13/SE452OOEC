package se452.group4.project.showtime.viewmodels;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UpdateShowtimeVm {
    @NonNull
    private UUID id;

    private UUID movieId;
    
    private UUID auditoriumId;
    
    private LocalDateTime time;  
}
