package Applications.OnlineHotelBookingSystem;
import java.util.*;

public class ReservationManager {
    List<Reservation> reservations;

    public ReservationManager(){
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public void cancelReservation(Reservation reservation){
        reservation.cancel();
    }

    public List<Reservation> getReservationByGuest(String guestId){
        List<Reservation> result= new ArrayList<>();
        for(Reservation r: reservations){
            if(r.getId().equals(guestId)){
                result.add(r);
            }
        }
        return result;
    }

    public Reservation getReservationById(String reservationId){
        for(Reservation r: reservations){
            if(r.getId().equals(reservationId)){
                return r;
            }
        }
        return null;
    }
}
