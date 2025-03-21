package project.redis.theater.mapper;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.cinema.Cinema;
import project.redis.cinema.entity.CinemaEntity;
import project.redis.cinema.mapper.CinemaMapper;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;
import project.redis.seat.mapper.SeatMapper;
import project.redis.theater.Theater;
import project.redis.theater.entity.TheaterEntity;

@Component
@RequiredArgsConstructor
public class TheaterMapperImpl implements TheaterMapper {

    private final SeatMapper seatMapper;
    private final CinemaMapper cinemaMapper;

    @Override
    public Theater toDomain(TheaterEntity theaterEntity) {
        List<SeatEntity> seatEntities = theaterEntity.getSeats();
        List<Seat> seats = convertSeatEntitiesToSeats(seatEntities);

        CinemaEntity cinemaEntity = theaterEntity.getCinema();
        Cinema cinema = cinemaMapper.toDomain(cinemaEntity);

        return Theater.of(theaterEntity.getTheaterId(), theaterEntity.getTheaterName(), cinema, seats);
    }

    public List<Seat> convertSeatEntitiesToSeats(List<SeatEntity> seatEntities) {
        return seatEntities.stream()
                .map(seatMapper::toDomain)
                .toList();
    }
}
