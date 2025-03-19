package project.redis.movie.mapper;

import org.springframework.stereotype.Component;
import project.redis.movie.Movie;
import project.redis.movie.entity.MovieEntity;

@Component
public class MovieMapperImpl implements MovieMapper {
    @Override
    public Movie toDomain(MovieEntity movieEntity) {
        return Movie.of(movieEntity.getTitle(), movieEntity.getRating(), movieEntity.getReleasedAt(),
                movieEntity.getThumbnail(), movieEntity.getDuration(), movieEntity.getGenre());
    }
}
