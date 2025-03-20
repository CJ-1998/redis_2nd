package project.redis.cinema.mapper;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.redis.cinema.Cinema;
import project.redis.cinema.entity.CinemaEntity;
import project.redis.seat.Seat;
import project.redis.seat.entity.SeatEntity;
import project.redis.seat.mapper.SeatMapper;

@Component
@RequiredArgsConstructor
public class CinemaMapperImpl implements CinemaMapper {

    private final SeatMapper seatMapper;

    @Override
    public Cinema toDomain(CinemaEntity cinemaEntity) {
        return Cinema.of(cinemaEntity.getCinemaId(), cinemaEntity.getCinemaName());
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
