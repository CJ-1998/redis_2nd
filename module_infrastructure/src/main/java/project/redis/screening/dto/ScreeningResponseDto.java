package project.redis.screening.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import project.redis.movie.MovieGenre;
import project.redis.movie.MovieRate;

@Getter
public class ScreeningResponseDto {
    private final String movieTitle;
    private final MovieRate rating;
    private final LocalDate releasedAt;
    private final String thumbnail;
    private final Integer duration;
    private final MovieGenre genre;
    private final String cinemaName;
    private final String theaterName;
    private final String cinemaAndTheaterName;
    private final LocalDateTime startedAt;
    private final LocalDateTime endedAt;

    @QueryProjection
    public ScreeningResponseDto(String movieTitle, MovieRate rating, LocalDate releasedAt,
                                String thumbnail, Integer duration, MovieGenre genre,
                                String cinemaName, String theaterName, String cinemaAndTheaterName,
                                LocalDateTime startedAt, LocalDateTime endedAt) {
        this.movieTitle = movieTitle;
        this.rating = rating;
        this.releasedAt = releasedAt;
        this.thumbnail = thumbnail;
        this.duration = duration;
        this.genre = genre;
        this.cinemaName = cinemaName;
        this.theaterName = theaterName;
        this.cinemaAndTheaterName = cinemaAndTheaterName;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    @Override
    public String toString() {
        return "ScreeningResponseDto{" +
                "movieTitle='" + movieTitle + '\'' +
                ", rating=" + rating +
                ", releasedAt=" + releasedAt +
                ", thumbnail='" + thumbnail + '\'' +
                ", duration=" + duration +
                ", genre=" + genre +
                ", cinemaName='" + cinemaName + '\'' +
                ", theaterName='" + theaterName + '\'' +
                ", cinemaAndTheaterName='" + cinemaAndTheaterName + '\'' +
                ", startedAt=" + startedAt +
                ", endedAt=" + endedAt +
                '}';
    }
}
