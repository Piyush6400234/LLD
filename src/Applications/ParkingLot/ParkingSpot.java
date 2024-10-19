package Applications.ParkingLot;
/*
We can have this class as abstract class but now, we don't have a reason, as both two and four wheeler
 spot have almost same functionality, except vehicle Type.
*/
public class ParkingSpot {
    private int id;
    private int rate;
    private Vehicle vehicle;
    private VehicleType type;
    private boolean isEmpty;
    public ParkingSpot(int id, int rate, VehicleType type) {
        this.id = id;
        this.rate = rate;
        this.vehicle = null;
        this.type = type;
        this.isEmpty = true;
    }
    public void parkVehicle(Vehicle vehicle) {
        if (this.isEmpty && vehicle.getType() == type) {
            System.out.println("parked: "+type.name()+" vehicle id: "+vehicle.getVehicleNo());
            this.isEmpty = false;
            this.vehicle = vehicle;
        }
    }
    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
        System.out.println("vehicle removed from parking spotId: "+id);
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }
    public boolean isEmpty() {
        return this.isEmpty;
    }
    public VehicleType getType(){
        return this.type;
    }
}