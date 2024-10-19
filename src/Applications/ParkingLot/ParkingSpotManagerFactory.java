package Applications.ParkingLot;
import java.util.*;
public class ParkingSpotManagerFactory {
    ParkingSpotManager getParkingSpotManager(VehicleType type, List<ParkingSpot> spots){
        if(type == VehicleType.TwoWheeler){
            return new TwoWheelerSpotManager(spots);
        }
        else if(type == VehicleType.FourWheeler){
            return new FourWheelerSpotManager(spots);
        }

        return null;
    }
}
