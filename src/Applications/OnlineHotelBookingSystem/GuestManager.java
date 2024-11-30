package Applications.OnlineHotelBookingSystem;
import java.util.*;

public class GuestManager {
    List<Guest> guests;

    public GuestManager(){
        guests = new ArrayList<>();
    }

    public void addGuest(Guest g){
        guests.add(g);
    }
    public void removeGuest(Guest g){
        guests.remove(g);
    }

    public Guest getGuestById(String id){
        for(Guest g: guests){
            if(g.getId().equals(id)){
                return g;
            }
        }
        return null;
    }

}
