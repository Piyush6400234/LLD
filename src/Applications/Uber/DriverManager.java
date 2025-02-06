package Applications.Uber;

import java.util.ArrayList;
import java.util.List;

public class DriverManager {
    private static DriverManager driverManager;
    List<Driver> driverList; // we can put a HashMap as well.
    private DriverManager(){
        driverList = new ArrayList<>();
    }
    public static DriverManager getInstance(){
        if(driverManager == null){
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public void addDriver(Driver driver){
        this.driverList.add(driver);
    }

    public Driver getDriver(String driverId){
        for(Driver d: driverList){
            if(d.getDriverId().equals(driverId)){
                return d;
            }
        }
        return null;
    }
    public int getTotalDrivers(){
        return driverList.size();
    }
    public List<Driver> getDriverList(){
        return driverList;
    }
}
