package Applications.BookMyShow;
import Applications.BookMyShow.Enums.*;
public class Seat {
    SeatCategory category;
    int seatId;

    public Seat(SeatCategory category, int seatId){
        this.category = category;
        this.seatId = seatId;
    }
    public int getSeatId() {
        return seatId;
    }

    public SeatCategory getCategory() {
        return category;
    }
}
