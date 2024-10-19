package Applications.ParkingLot;

public class Vehicle {
    private String VehicleNo;
    private VehicleType type;
    public Vehicle(String VehicleNo, VehicleType type){
        this.VehicleNo = VehicleNo;
        this.type = type;
    }
    public VehicleType getType(){
        return type;
    }

    public String getVehicleNo(){
        return this.VehicleNo;
    }
}
