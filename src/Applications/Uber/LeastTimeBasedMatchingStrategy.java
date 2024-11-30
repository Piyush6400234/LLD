package Applications.Uber;

import java.util.List;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {
    @Override
    public Driver matchDriver(TripMetaData tripMetaData){
        DriverManager driverManager = DriverManager.getInstance();

        if(driverManager.getTotalDrivers() == 0){
            System.out.println("No driver registered!");
        }
        System.out.println("Using quadtree to see nearest cabs, using driver manager to get details of drivers and send notifications");
        List<Driver> a = driverManager.getDriverList();
        Driver driver = a.get(0);
        System.out.println("Setting "+ driver.getName() + " with id: "+driver.getDriverId()+" as driver.");
        tripMetaData.setDriverRating(driver.getRating());
        return driver;
    }
}
