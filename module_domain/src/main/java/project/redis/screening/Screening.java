package project.redis.screening;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.movie.Movie;
import project.redis.theater.Theater;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Screening {

    private Long screeningId;
    private Movie movie;
    private Theater theater;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    public static Screening of(Long screeningId, Movie movie, Theater theater, LocalDateTime startedAt,
                               LocalDateTime endedAt) {
        return new Screening(screeningId, movie, theater, startedAt, endedAt);
    }

    public String getCinemaName() {
        return this.theater.getTheaterName();
    }
}
