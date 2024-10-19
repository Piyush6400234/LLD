package Applications.BookMyShow;
import java.util.*;

public class Show {
    Movie movie;
    List<Integer>seatBooked = new ArrayList<>();
    int showId;
    Screen screen;
    int showStartTime;

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(int showStartTime) {
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }
    public void setSeatBooked(int seatId){
        this.seatBooked.add(seatId);
    }

    public List<Integer> getSeatBooked() {
        return seatBooked;
    }
}