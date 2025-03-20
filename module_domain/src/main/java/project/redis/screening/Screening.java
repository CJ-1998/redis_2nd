package project.redis.screening;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.cinema.Cinema;
import project.redis.movie.Movie;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Screening {

    private Long screeningId;
    private Movie movie;
    private Cinema cinema;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    public static Screening of(Long screeningId, Movie movie, Cinema cinema, LocalDateTime startedAt,
                               LocalDateTime endedAt) {
        return new Screening(screeningId, movie, cinema, startedAt, endedAt);
    }

    public String getCinemaName() {
        return this.cinema.getCinemaName();
    }
}
