package project.redis.screening.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.cinema.Cinema;
import project.redis.cinema.mapper.CinemaMapper;
import project.redis.movie.Movie;
import project.redis.movie.mapper.MovieMapper;
import project.redis.screening.Screening;
import project.redis.screening.entity.ScreeningEntity;

@Component
@RequiredArgsConstructor
public class ScreeningMapperImpl implements ScreeningMapper {

    private final MovieMapper movieMapper;
    private final CinemaMapper cinemaMapper;

    @Override
    public Screening toDomain(ScreeningEntity screeningEntity) {
        Movie movie = movieMapper.toDomain(screeningEntity.getMovie());
        Cinema cinema = cinemaMapper.toDomain(screeningEntity.getCinema());
        return Screening.of(movie, cinema,
                screeningEntity.getStartedAt(), screeningEntity.getEndedAt());
    }
}
