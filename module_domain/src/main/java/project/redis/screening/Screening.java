package project.redis.screening;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.redis.movie.Movie;
import project.redis.theater.Theater;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Screening {

    private Long screeningId;
    private Movie movie;
    private Theater theater;

    @Getter
    private LocalDateTime startedAt;
    @Getter
    private LocalDateTime endedAt;

    public static Screening of(Long screeningId, Movie movie, Theater theater, LocalDateTime startedAt,
                               LocalDateTime endedAt) {
        return new Screening(screeningId, movie, theater, startedAt, endedAt);
    }

    public String fetchTheaterAndCinemaName() {
        Theater theater = this.theater;
        String theaterName = theater.getTheaterName();
        String cinemaName = theater.getCinemaNameOfTheater();
        return cinemaName + " " + theaterName;
    }
}
