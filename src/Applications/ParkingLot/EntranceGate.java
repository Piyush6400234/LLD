package Applications.ParkingLot;
import java.util.*;

public class EntranceGate {
    private int gateId;
    ParkingSpotManagerFactory spotManagerFactory;
    ParkingSpotManager spotManager;
    public EntranceGate(int gateId){
        this.gateId = gateId;
        spotManagerFactory = new ParkingSpotManagerFactory();// not needed though
    }
    public ParkingSpot findParkingSpot(VehicleType type){
        spotManager  = ParkingSpotManagerFactory.getParkingSpotManager(type);
        ParkingSpot spot = null;
        if(spotManager!=null)
            spot = spotManager.findParkingSpace(type);

        return spot;
    }
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot, int entryTime){
        spot.parkVehicle(vehicle);
        return new Ticket(entryTime, spot);
    }
}