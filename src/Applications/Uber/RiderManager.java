package Applications.Uber;

import java.util.ArrayList;
import java.util.List;

public class RiderManager {
    private static RiderManager riderManager;
    List<Rider> riderList; // we can put a HashMap as well.
    private RiderManager(){
        riderList = new ArrayList<>();
    }
    public static RiderManager getInstance(){
        if(riderManager == null){
            riderManager = new RiderManager();
        }
        return riderManager;
    }

    public void addRider(Rider rider){
        this.riderList.add(rider);
    }

    public Rider getRider(String riderId){
        for(Rider d: riderList){
            if(d.getRiderId().equals(riderId)){
                return d;
            }
        }
        return null;
    }
}
