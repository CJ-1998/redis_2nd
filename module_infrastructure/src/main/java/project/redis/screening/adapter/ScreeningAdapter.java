package project.redis.screening.adapter;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.movie.Movie;
import project.redis.movie.entity.MovieEntity;
import project.redis.screening.Screening;
import project.redis.screening.entity.ScreeningEntity;
import project.redis.screening.mapper.ScreeningMapper;
import project.redis.screening.repository.ScreeningRepository;

@Component
@RequiredArgsConstructor
public class ScreeningAdapter {

    private final ScreeningRepository screeningRepository;
    private final ScreeningMapper screeningMapper;

    public List<Screening> findScreeningsByMovie(Movie movie) {
        MovieEntity movieEntity = MovieEntity.of(movie);
        List<ScreeningEntity> screeningEntities = screeningRepository.findByMovie(movieEntity);
        return screeningEntities.stream()
                .map(screeningMapper::toDomain)
                .toList();
    }
}
