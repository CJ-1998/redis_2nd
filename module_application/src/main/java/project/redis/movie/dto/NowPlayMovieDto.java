package project.redis.movie.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import project.redis.movie.Movie;
import project.redis.screening.dto.ScreeningTimeDto;

@Getter
@Builder
public class NowPlayMovieDto {
    private String movieName;
    private String movieRate;
    private LocalDate movieReleaseDate;
    private String movieThumbnailImage;
    private Integer movieRunningTime;
    private String movieGenre;
    private String theaterAndCinemaName;
    private List<ScreeningTimeDto> screenings;

    public static NowPlayMovieDto of(Movie movie, String theaterAndCinemaName, List<ScreeningTimeDto> screenings) {
        return NowPlayMovieDto.builder()
                .movieName(movie.getTitle())
                .movieRate(movie.getRating().getMovieRateDescription())
                .movieReleaseDate(movie.getReleasedAt())
                .movieThumbnailImage(movie.getThumbnail())
                .movieRunningTime(movie.getDuration())
                .movieGenre(movie.getGenre().getMovieGenreDescription())
                .theaterAndCinemaName(theaterAndCinemaName)
                .screenings(screenings)
                .build();
    }
}
