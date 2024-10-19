package Applications.ParkingLot;
import java.util.*;
/*
Requirements: vehicle comes to Enterance Gate
            - Owner gets ticket at gate.
            - Owner parks his vehicle at a parking Spot he was allotted at the entrance gate.
            - At Exit gate he should be able to make his Payments and exits.
            - 1 Entrance, 1 Exit gate (But code should be extensible so in future can be scaled to 2 or 3)
    Also, there can be different types of Parking Spots
        - Two wheeler spot, four wheeler spot e.t.c (extensible as well)
    Payment strategy: Should be hourly based or Minute based e.t.c Or It should be mixed, for some spots
            it should be hourly and for others maybe minute based
    Are there multiple floors?

Objects: Tickets ----> Entry time, Exit time, parking spot, rate of parking spot, optional(entrance gate, exit gate).
         vehicles ----> Vehicle Number, Vehicle Type(Enum 2 wheeler, 4 wheeler).
         Entrance Gate ----> Find Parking space(if not present do not let vehicle book it, find optimized space, nearest from entrance or from exit),
                             update parking slot(how many left or occupied etc), generate ticket.
         Parking Spots ----> ID, isEmpty, vehicle present, type, price/rate,
         Exit Gate ----> Cost Calculation, payment, Update parking spot


patterns used: Factory, Strategy

*/
public class Main {
    public static void main(String[] args) {
//        --------------------------- :This much code to be handled before Appliction starts
        List<ParkingSpot> fourWheelerSpots = new ArrayList<>();
        for(int i = 1; i<8; i++){
            ParkingSpot fourWheelerSpot = new ParkingSpot(i, 10, VehicleType.FourWheeler);
            fourWheelerSpots.add(fourWheelerSpot);
        }
        List<ParkingSpot> twoWheelerSpots = new ArrayList<>();
        for(int i = 1; i<8; i++){
            ParkingSpot twoWheelerSpot = new ParkingSpot(i, 10, VehicleType.TwoWheeler);
            twoWheelerSpots.add(twoWheelerSpot);
        }


        ParkingSpotManagerFactory factory = new ParkingSpotManagerFactory();
        ParkingSpotManager fourWheelerManager = factory.getParkingSpotManager(VehicleType.FourWheeler);
        ParkingSpotManager twoWheelerManager = factory.getParkingSpotManager(VehicleType.TwoWheeler);
        fourWheelerManager.addParkingSpots(fourWheelerSpots);
        twoWheelerManager.addParkingSpots(twoWheelerSpots);
        EntranceGate entryGate1 = new EntranceGate(1);
        ExitGate exitGate1 = new ExitGate();
//        -----------------------------------------------------

        Vehicle car1 = new Vehicle("523654", VehicleType.FourWheeler);


        ParkingSpot spot1 = entryGate1.findParkingSpot(VehicleType.FourWheeler);
        if(spot1 == null){
            System.out.println("spot null");
            return;
        }
        Ticket ticket1 = entryGate1.generateTicket(car1, spot1, 2100);
        System.out.println("Entry time: "+ticket1.getEntryTime());
        System.out.println("Ticket Id: "+ticket1.getTicketId());
        System.out.println("Type of vehicle parked: "+ticket1.getVehicle().getType().name());
        System.out.println("is Spot empty: "+ticket1.getSpot().isEmpty());
        System.out.println("Vehicle No: "+ticket1.getVehicle().getVehicleNo());
        System.out.println("removing vehicle at exit gate");
        exitGate1.removeTicket(ticket1);


    }
}
