package se452.group4.project.movie.viewmodels;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UpdateMovieVm {
    @NonNull
    private UUID id;

    private String title;
    
    private String description;
    
    private Integer durationInMinutes;
}
