package Applications.ParkingLot;
import java.util.*;
// FourWheelerSpotManager is singleton, used LazyInitialization (Not thread safe).
public class FourWheelerSpotManager extends ParkingSpotManager{
    private static FourWheelerSpotManager spotManager;
    private FourWheelerSpotManager(){
        super();
    }
    public static FourWheelerSpotManager getInstance(){
        if(spotManager == null){
            spotManager = new FourWheelerSpotManager();
        }
        return spotManager;
    }
    @Override
    public ParkingSpot findParkingSpace(VehicleType type){
        // Implement your own logic for nearest or farthest spot. Using Strategy or whatever.

        for(ParkingSpot spot : spots){
            if(spot.getType() == type && spot.isEmpty()){
                return spot;
            }
        }
        return null;
    }
}