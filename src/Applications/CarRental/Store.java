package Applications.CarRental;
import java.util.*;
import Applications.CarRental.Product.*;
// To avoid bulking-up Store class we use InventoryManager, it will be responsible for managing all the vehicles
// Present, or adding new Vehicle, modifying/updating existing vehicle.

public class Store {
    private int storeId;
    private VehicleInventoryManager vehicleInventoryManager;
    private Location storeLocation;
    private List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(){
        return vehicleInventoryManager.getVehicles();
    }
    public Location getLocation(){
        return this.storeLocation;
    }
    public void setLocation(Location location){
        this.storeLocation = location;
    }
    public void setVehicle(List<Vehicle> vehicles){
        this.vehicleInventoryManager = new VehicleInventoryManager(vehicles);
    }
    public List<Vehicle> getVehicleBasedOnVehicleType(VehicleType type){
        List<Vehicle> vehicles = new ArrayList<>();
        for(Vehicle v: vehicleInventoryManager.getVehicles()){
            if(v.getVehicleType() == type){
                vehicles.add(v);
            }
        }
        return vehicles;
    }
    public Reservation createReservation(int vehicleId, User user){
        List<Vehicle> available = getVehicles();
        Vehicle vehicle = null;
        for(Vehicle veh: available){
            if(veh.getVehicleID() == vehicleId){
                vehicle = veh;
                break;
            }
        }
        if(vehicle == null){
            System.out.println("No vehicle found");
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.createReservation(user, vehicle);
        reservation.setReservationStatus(ReservationStatus.SCHEDULED);
//        reservation.setReservationId((int)(Math.random()*1000));
        reservations.add(reservation);
        return reservation;
    }
    public Bill completeReservation(int reservationID) {
        // take out the reservation object from the list and call complete the reservation method.

        for (Reservation res : this.reservations) {
            if (res.getReservationId() == reservationID) {
                res.setReservationStatus(ReservationStatus.INPROGRESS);
                Bill bill = new Bill(res);
                return bill;
            }
        }
        return null;
    }
}