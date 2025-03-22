package project.redis.theater;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import project.redis.cinema.Cinema;
import project.redis.seat.Seat;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Theater {
    private Long theaterId;
    @Getter
    private String theaterName;
    private Cinema cinema;
    private TheaterSeats theaterSeats;

    public static Theater of(Long theaterId, String theaterName, Cinema cinema) {
        return new Theater(theaterId, theaterName, cinema, TheaterSeats.create());
    }

    public static Theater of(Long theaterId, String theaterName, Cinema cinema, List<Seat> seats) {
        return new Theater(theaterId, theaterName, cinema, TheaterSeats.create(seats));
    }

    public String getCinemaNameOfTheater() {
        return cinema.getCinemaName();
    }
}
