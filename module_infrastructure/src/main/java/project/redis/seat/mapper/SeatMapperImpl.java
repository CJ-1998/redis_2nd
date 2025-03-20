package project.redis.seat.mapper;

import org.springframework.stereotype.Component;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;

@Component
public class SeatMapperImpl implements SeatMapper {
    @Override
    public Seat toDomain(SeatEntity seatEntity) {
        return Seat.of(seatEntity.getSeatId(), seatEntity.getIsReserved(),
                seatEntity.getSeatRow(), seatEntity.getSeatColumn());
    }
}
