package se452.group4.project.movie.viewmodels;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class NewMovieVm {
    @NonNull
    private String title;
    
    @NonNull
    private String description;
    
    private int durationInMinutes;
}
