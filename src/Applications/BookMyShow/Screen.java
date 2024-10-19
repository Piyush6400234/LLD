package Applications.BookMyShow;
import Applications.BookMyShow.Enums.*;
import java.util.*;
public class Screen {
    List<Seat> seatList = new ArrayList<>();
    int screenId;

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
