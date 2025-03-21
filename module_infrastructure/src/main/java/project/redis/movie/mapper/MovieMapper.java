package project.redis.movie.mapper;

import project.redis.movie.Movie;
import project.redis.movie.entity.MovieEntity;

public interface MovieMapper {
    Movie toDomain(MovieEntity movieEntity);

    MovieEntity toEntity(Movie movie);
}
