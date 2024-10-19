package Applications.ParkingLot;
import java.util.*;
// Ideally both the Spot Managers should be singleton.
public class FourWheelerSpotManager extends ParkingSpotManager{

    public FourWheelerSpotManager(List<ParkingSpot> spots){
        super(spots);
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