package project.redis.movie.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.redis.screening.Screening;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class NowPlayMovieDto {
    private String movieName;
    private String movieRate;
    private LocalDate movieReleaseDate;
    private String movieThumbnailImage;
    private Integer movieRunningTime;
    private String movieGenre;
    private String cinemaName;
    private List<Screening> screenings;
}
