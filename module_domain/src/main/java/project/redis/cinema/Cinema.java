package project.redis.cinema;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import project.redis.theater.Theater;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {

    private Long cinemaId;

    private String cinemaName;

    private List<Theater> theaters;

    public static Cinema of(Long cinemaId, String cinemaName, List<Theater> theaters) {
        return new Cinema(cinemaId, cinemaName, theaters);
    }
}
