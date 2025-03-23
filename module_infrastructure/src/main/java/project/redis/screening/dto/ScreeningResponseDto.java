package project.redis.screening.dto;

import com.querydsl.core.annotations.QueryProjection;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import project.redis.movie.MovieGenre;
import project.redis.movie.MovieRate;

@Getter
public class ScreeningResponseDto {
    private String movieTitle;
    private MovieRate rating;
    private LocalDate releasedAt;
    private String thumbnail;
    private Integer duration;
    private MovieGenre genre;
    private String cinemaName;
    private String theaterName;
    private List<String> screeningTimes; // startedAt ~ endedAt 리스트

    @QueryProjection
    public ScreeningResponseDto(String movieTitle, MovieRate rating,
                                LocalDate releasedAt, String thumbnail, Integer duration,
                                MovieGenre genre, String cinemaName, String theaterName, List<String> screeningTimes) {
        this.movieTitle = movieTitle;
        this.rating = rating;
        this.releasedAt = releasedAt;
        this.thumbnail = thumbnail;
        this.duration = duration;
        this.genre = genre;
        this.cinemaName = cinemaName;
        this.theaterName = theaterName;
        this.screeningTimes = screeningTimes;
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
                ", screeningTimes=" + screeningTimes +
                '}';
    }
}
