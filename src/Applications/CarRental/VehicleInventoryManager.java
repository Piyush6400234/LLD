package Applications.CarRental;
import Applications.CarRental.Product.Vehicle;
// It can do CRUD operations to add remove delete update vehicles in my Inventory or change/modify any specific vehicle
// Or later it can be extended for two wheeler/four wheeler VehicleManager.
import java.util.*;
public class VehicleInventoryManager {
    private List<Vehicle> vehicles;
    public VehicleInventoryManager(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
    public List<Vehicle> getVehicles(){
        return this.vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
}