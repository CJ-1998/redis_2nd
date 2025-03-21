package project.redis.screening.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.movie.Movie;
import project.redis.movie.mapper.MovieMapper;
import project.redis.screening.Screening;
import project.redis.screening.entity.ScreeningEntity;
import project.redis.theater.Theater;
import project.redis.theater.mapper.TheaterMapper;

@Component
@RequiredArgsConstructor
public class ScreeningMapperImpl implements ScreeningMapper {

    private final MovieMapper movieMapper;
    private final TheaterMapper theaterMapper;

    @Override
    public Screening toDomain(ScreeningEntity screeningEntity) {
        Movie movie = movieMapper.toDomain(screeningEntity.getMovie());
        Theater theater = theaterMapper.toDomain(screeningEntity.getCinema());
        return Screening.of(screeningEntity.getScreeningId(), movie, theater,
                screeningEntity.getStartedAt(), screeningEntity.getEndedAt());
    }
}
