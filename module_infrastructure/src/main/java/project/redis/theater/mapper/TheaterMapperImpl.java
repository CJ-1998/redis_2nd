package project.redis.theater.mapper;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;
import project.redis.seat.mapper.SeatMapper;
import project.redis.theater.Theater;
import project.redis.theater.entity.TheaterEntity;

@Component
@RequiredArgsConstructor
public class TheaterMapperImpl implements TheaterMapper {

    private final SeatMapper seatMapper;

    @Override
    public Theater toDomain(TheaterEntity theaterEntity) {
        List<Seat> seats = convertSeatEntitiesToSeats(theaterEntity.getSeats());
        return Theater.of(theaterEntity.getTheaterId(), theaterEntity.getTheaterName(), seats);
    }

    public List<Seat> convertSeatEntitiesToSeats(List<SeatEntity> seatEntities) {
        return seatEntities.stream()
                .map(seatMapper::toDomain)
                .toList();
    }
}
