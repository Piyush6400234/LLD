package Applications.Uber;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rider rider1 = new Rider("rider1", 5);
        Rider rider2 = new Rider("rider2", 4);
        RiderManager riderManager = RiderManager.getInstance();
        riderManager.addRider(rider1);
        riderManager.addRider(rider2);

        Driver driver1 = new Driver("driver1", 2);
        Driver driver2 = new Driver("driver2", 5);

        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(driver1);
        driverManager.addDriver(driver2);
        /*
        These details in turn will be stored in database
        -----------------------------------------------------
        */

        TripManager tripManager = TripManager.getInstance();
        tripManager.createTrip(rider1, new Location(30, 30), new Location(100, 100));

        tripManager.createTrip(rider2, new Location(100, 100), new Location(200, 200));
        List<Trip> lis= tripManager.getTripList();
        for(Trip t: lis){
            t.displayTripDetails();
        }
    }
}
