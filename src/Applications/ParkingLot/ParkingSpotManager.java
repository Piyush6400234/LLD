package Applications.ParkingLot;
import java.util.*;
// Ideally both the Spot Managers should be singleton.
public abstract class ParkingSpotManager {
    protected List<ParkingSpot> spots;
    public ParkingSpotManager(List<ParkingSpot> spots){
        this.spots = new ArrayList<>();
        this.spots.addAll(spots);
        // use APIs to fetch the ParkingSpots data From DataBase/InMemory.
    }
    public void addParkingSpots(List<ParkingSpot> spots){ // this is to feed the ParkingManager
        this.spots.addAll(spots);
    }
    public int getSpotCount(){
        return this.spots.size();
    }

    public abstract ParkingSpot findParkingSpace(VehicleType type);
    public void parkVehicle(Vehicle v){
        ParkingSpot spot = findParkingSpace(v.getType());
        spot.parkVehicle(v);
    }
    public void removeVehicle(Vehicle v){
        for(ParkingSpot spot: spots){
            if(spot.getVehicle() != null && spot.getVehicle() == v){
                spot.removeVehicle();
                break;
            }
        }
    }
}
