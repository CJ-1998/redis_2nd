package project.redis.movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.movie.Movie;
import project.redis.screening.dto.ScreeningResponseDto;
import project.redis.screening.dto.ScreeningTimeDto;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NowPlayMovieDto {
    private String title;
    private String rating;
    private LocalDate releasedAt;
    private String thumbnail;
    private Integer runningTime;
    private String genre;
    private String theaterAndCinemaName;
    private List<ScreeningTimeDto> screenings;

    public static NowPlayMovieDto of(Movie movie, String theaterAndCinemaName, List<ScreeningTimeDto> screenings) {
        return NowPlayMovieDto.builder()
                .title(movie.getTitle())
                .rating(movie.getRating().getMovieRateDescription())
                .releasedAt(movie.getReleasedAt())
                .thumbnail(movie.getThumbnail())
                .runningTime(movie.getDuration())
                .genre(movie.getGenre().getMovieGenreDescription())
                .theaterAndCinemaName(theaterAndCinemaName)
                .screenings(screenings)
                .build();
    }

    public static NowPlayMovieDto createByQueryDto(ScreeningResponseDto screeningResponseDto,
                                                   List<ScreeningTimeDto> screenings) {
        return NowPlayMovieDto.builder()
                .title(screeningResponseDto.getMovieTitle())
                .rating(screeningResponseDto.getRating().getMovieRateDescription())
                .releasedAt(screeningResponseDto.getReleasedAt())
                .thumbnail(screeningResponseDto.getThumbnail())
                .runningTime(screeningResponseDto.getDuration())
                .genre(screeningResponseDto.getGenre().getMovieGenreDescription())
                .theaterAndCinemaName(screeningResponseDto.getCinemaAndTheaterName())
                .screenings(screenings)
                .build();
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getReleasedAt() {
        return releasedAt;
    }
}
