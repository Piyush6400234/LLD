package Applications.BookMyShow;
import java.util.*;
public class Booking {
    Show showBooked;
    List<Seat> bookedSeats = new ArrayList<>();
    Payment payment;

    public void setBookedSeats(List<Seat> bookedSeats){
        this.bookedSeats = bookedSeats;
    }

    public void setBookedShow(Show show){
        this.showBooked = show;
    }
    public void setPayment(Payment payment){
        this.payment = payment;
    }

}
