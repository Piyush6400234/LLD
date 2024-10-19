package Applications.ParkingLot;
import java.util.*;

public class Ticket {
    private int entryTime;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private int ticketId;

    public Ticket(int entryTime, Vehicle vehicle, ParkingSpot spot){
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.spot = spot;
        Random random = new Random();
        this.ticketId = 1000+ random.nextInt(9000);
    }
    public int getEntryTime(){
        return this.entryTime;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    public ParkingSpot getSpot(){
        return this.spot;
    }
    public int getTicketId(){
        return this.ticketId;
    }
}