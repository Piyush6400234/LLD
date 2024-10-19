package Applications.ParkingLot;
import java.util.*;

public class Ticket {
    private int entryTime;
    private ParkingSpot spot;
    private Vehicle vehicle;
    private int ticketId;

    public Ticket(int entryTime, ParkingSpot spot){
        this.entryTime = entryTime;
        this.spot = spot;
        Random random = new Random();
        this.vehicle = spot.getVehicle();
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