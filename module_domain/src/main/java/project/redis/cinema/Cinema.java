package project.redis.cinema;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cinema {

    private Long cinemaId;

    private String cinemaName;

    public static Cinema of(Long cinemaId, String cinemaName) {
        return new Cinema(cinemaId, cinemaName);
    }
}
