package project.redis.cinema.mapper;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.cinema.Cinema;
import project.redis.cinema.entity.CinemaEntity;
import project.redis.theater.Theater;
import project.redis.theater.entity.TheaterEntity;
import project.redis.theater.mapper.TheaterMapper;

@Component
@RequiredArgsConstructor
public class CinemaMapperImpl implements CinemaMapper {

    private final TheaterMapper theaterMapper;

    @Override
    public Cinema toDomain(CinemaEntity cinemaEntity) {
        List<TheaterEntity> theaterEntities = cinemaEntity.getTheaters();
        List<Theater> theaters = convertTheaterEntitiesToTheaters(theaterEntities);
        return Cinema.of(cinemaEntity.getCinemaId(), cinemaEntity.getCinemaName(), theaters);
    }

    public List<Theater> convertTheaterEntitiesToTheaters(List<TheaterEntity> theaterEntities) {
        return theaterEntities.stream()
                .map(theaterMapper::toDomain)
                .toList();
    }
}
