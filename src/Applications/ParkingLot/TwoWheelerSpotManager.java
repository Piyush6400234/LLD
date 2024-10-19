package Applications.ParkingLot;
import java.util.*;
// TwoWheelerSpotManager is Singleton.
public class TwoWheelerSpotManager extends ParkingSpotManager{
    private static TwoWheelerSpotManager spotManager;
    private TwoWheelerSpotManager(){
        super();
    }
    public static TwoWheelerSpotManager getInstance(){
        if(spotManager == null){
            spotManager = new TwoWheelerSpotManager();
        }
        return spotManager;
    }
    @Override
    public ParkingSpot findParkingSpace(VehicleType type){
        // Implement your own Algo for Two Wheelers
        for(ParkingSpot spot : spots){
            if(spot.getType() == type && spot.isEmpty()){
                return spot;
            }
        }
        return null;
    }
}