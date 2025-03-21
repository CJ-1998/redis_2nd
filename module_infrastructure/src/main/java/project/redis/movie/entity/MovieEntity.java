package project.redis.movie.entity;

import static jakarta.persistence.EnumType.STRING;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.redis.common.entity.BaseEntity;
import project.redis.movie.Movie;
import project.redis.movie.MovieGenre;
import project.redis.movie.MovieRate;

@Entity
@Table(name = "movie")
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MovieEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    private String title;

    @Enumerated(value = STRING)
    @Column(nullable = false)
    private MovieRate rating;

    @Column(nullable = false)
    private LocalDate releasedAt;

    @Column(length = 500)
    private String thumbnail;

    @Column(nullable = false)
    private Integer duration;

    @Enumerated(value = STRING)
    @Column(nullable = false)
    private MovieGenre genre;

    public static MovieEntity of(Movie movie) {
        return MovieEntity.builder()
                .movieId(movie.getMovieId())
                .title(movie.getTitle())
                .rating(movie.getRating())
                .releasedAt(movie.getReleasedAt())
                .thumbnail(movie.getThumbnail())
                .duration(movie.getDuration())
                .genre(movie.getGenre())
                .build();
    }

}
