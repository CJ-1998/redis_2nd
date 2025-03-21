package project.redis.theater;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Theater {
    private Long theaterId;
    @Getter
    private String theaterName;
    private TheaterSeats theaterSeats;

    public static Theater of(Long theaterId, String theaterName) {
        return new Theater(theaterId, theaterName, TheaterSeats.create());
    }
}
