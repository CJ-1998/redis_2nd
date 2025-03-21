package project.redis.theater;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.redis.seat.Seat;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Theater {
    private Long theaterId;
    @Getter
    private String theaterName;
    private TheaterSeats theaterSeats;

    public static Theater of(Long theaterId, String theaterName) {
        return new Theater(theaterId, theaterName, TheaterSeats.create());
    }

    public static Theater of(Long theaterId, String theaterName, List<Seat> seats) {
        return new Theater(theaterId, theaterName, TheaterSeats.create(seats));
    }
}
