package project.redis.theater;

import java.util.ArrayList;
import java.util.List;
import project.redis.seat.Seat;

public class TheaterSeats {

    public static final int ROWS = 5;
    public static final int COLUMNS = 5;

    private final List<Seat> seats;

    private TheaterSeats() {
        seats = new ArrayList<>();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                Seat oneSeat = createOneSeat(row, col);
                seats.add(oneSeat);
            }
        }
    }

    private TheaterSeats(List<Seat> seats) {
        this.seats = new ArrayList<>(seats);
    }

    public static TheaterSeats create() {
        return new TheaterSeats();
    }

    public static TheaterSeats create(List<Seat> seats) {
        return new TheaterSeats(seats);
    }

    private Seat createOneSeat(int row, int col) {
        String seatRow = getSeatRow(row);
        Integer setColumn = col + 1;
        return Seat.of(null, false, seatRow, setColumn);
    }

    private String getSeatRow(int rowNumber) {
        return String.valueOf((char) ('A' + rowNumber));
    }
}
