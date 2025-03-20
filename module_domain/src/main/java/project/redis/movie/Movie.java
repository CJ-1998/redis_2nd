package project.redis.movie;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Movie {

    private Long movieId;
    private String title;
    private MovieRate rating;
    private LocalDate releasedAt;
    private String thumbnail;
    private Integer duration;
    private MovieGenre genre;

    public static Movie of(Long movieId, String title, MovieRate rating, LocalDate releasedAt,
                           String thumbnail, Integer duration, MovieGenre genre) {
        return new Movie(movieId, title, rating, releasedAt, thumbnail, duration, genre);
    }

    public boolean isReleasedBefore(LocalDate date) {
        return releasedAt.isBefore(date);
    }

    public int compareReleaseDate(Movie movieToCompare) {
        return movieToCompare.releasedAt.compareTo(this.releasedAt);
    }

}
