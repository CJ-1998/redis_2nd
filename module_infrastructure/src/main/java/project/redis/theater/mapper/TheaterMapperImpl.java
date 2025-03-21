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
        return Theater.of(theaterEntity.getTheaterId(), theaterEntity.getTheaterName());
    }

    public List<Seat> convertSeatEntitiesToSeats(List<SeatEntity> seatEntities) {
        return seatEntities.stream()
                .map(seatMapper::toDomain)
                .toList();
    }

    // CineamSeats를 Cinema 생성할 때마다 자동 생성하게 하니 Entity에서 domain 클래스로 변환할 때 어떻게 해야 할지 모르겠음
    /*
    public CinemaSeats convertSeatsToCinemaSeats(List<Seat> seats) {
        List<Seat> sortedSeats = sortSeats(seats);

        List<List<Seat>> cinemaSeats = new ArrayList<>();

        String startRow = sortedSeats.get(0).getSeatRow();
        int index = 0;
        return null;
    }

    private List<Seat> sortSeats(List<Seat> seats) {
        seats.sort((seat1, seat2) -> {
            // row 비교
            int rowComparison = seat1.compareRow(seat2);
            if (rowComparison != 0) {
                return rowComparison;
            }
            // col 비교
            return seat1.compareCol(seat2);
        });
        return seats;
    }
     */
}
