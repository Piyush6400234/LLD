package Applications.ParkingLot;
import java.util.*;

public class EntranceGate {
    private int gateId;
    public EntranceGate(int gateId){
        this.gateId = gateId;
    }
    public ParkingSpot findParkingSpot(VehicleType type, ParkingSpotManager spotManager){
        ParkingSpot spot = spotManager.findParkingSpace(type);

        return spot;
    }
    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot, int entryTime){
        spot.parkVehicle(vehicle);
        return new Ticket(entryTime, vehicle, spot);
    }
}