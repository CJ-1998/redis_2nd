package project.redis.cinema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {
    private Long cinemaId;
    @Getter
    private String cinemaName;
    private CinemaSeats cinemaSeats;

    public static Cinema of(Long cinemaId, String cinemaName) {
        return new Cinema(cinemaId, cinemaName, CinemaSeats.create());
    }
}
