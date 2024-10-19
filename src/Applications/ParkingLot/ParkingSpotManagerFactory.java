package Applications.ParkingLot;
import java.util.*;
public class ParkingSpotManagerFactory {
    static ParkingSpotManager  getParkingSpotManager(VehicleType type){
        if(type == VehicleType.TwoWheeler){
            return TwoWheelerSpotManager.getInstance();
        }
        else if(type == VehicleType.FourWheeler){
            return FourWheelerSpotManager.getInstance();
        }
        return null;
    }
}