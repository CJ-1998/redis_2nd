package project.redis.cinema.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.cinema.Cinema;
import project.redis.cinema.entity.CinemaEntity;

@Component
@RequiredArgsConstructor
public class CinemaMapperImpl implements CinemaMapper {

    @Override
    public Cinema toDomain(CinemaEntity cinemaEntity) {
        return Cinema.of(cinemaEntity.getCinemaId(), cinemaEntity.getCinemaName());
    }
}
