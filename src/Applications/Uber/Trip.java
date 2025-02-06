package Applications.Uber;

public class Trip {
    private String tripId;
    private Rider rider;
    private Driver driver;
    private Location srcLoc;
    private Location dstLoc;
    private TripStatus status;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public Trip(String tripId, Rider rider, Driver driver, Location srcLoc, Location dstLoc, double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.tripId = tripId;
        this.rider = rider;
        this.driver = driver;
        this.srcLoc = srcLoc;
        this.dstLoc = dstLoc;
        this.status = TripStatus.DRIVER_ON_THE_WAY;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
    }

    public String getTripId(){
        return this.tripId;
    }
    public void displayTripDetails(){
        System.out.println("Trip id - "+ tripId
        +" Rider - " + rider.getName() + " Driver - "+ driver.getName() + " price "+ price + " srcLoc - "+ srcLoc.getLong() +", "+srcLoc.getLat());
    }

}
