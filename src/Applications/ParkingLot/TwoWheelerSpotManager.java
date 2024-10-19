package Applications.ParkingLot;
import java.util.*;
// Ideally both the Spot Managers should be singleton.
public class TwoWheelerSpotManager extends ParkingSpotManager{

    public TwoWheelerSpotManager(List<ParkingSpot> spots){
        super(spots);
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