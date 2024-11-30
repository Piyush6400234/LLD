package Applications.Uber;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TripManager {
    private static TripManager tripManager;
    private List<Trip> tripList;
    private List<TripMetaData> tripMetaDataList;
    private RiderManager riderManager;
    private DriverManager driverManager;

    private TripManager(){
        riderManager = RiderManager.getInstance();
        driverManager = DriverManager.getInstance();
        tripList = new ArrayList<>();
        tripMetaDataList = new ArrayList<>();
    }
    public static TripManager getInstance(){
        if(tripManager == null){
            tripManager = new TripManager();
        }
        return tripManager;
    }

    public void createTrip(Rider rider, Location srcLoc, Location dstLoc){
        TripMetaData tripMetaData = new TripMetaData(srcLoc, dstLoc, rider.getRating());
        StrategyManager strategyManager =  StrategyManager.getInstance();
        PricingStrategy pricingStrategy = strategyManager.determinePricingStrategy(tripMetaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyManager.determineMatchingStrategy(tripMetaData);
        Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);
        double tripPrice = pricingStrategy.calculatePrice(tripMetaData);

        Trip trip = new Trip(UUID.randomUUID().toString(), rider, driver, srcLoc, dstLoc, tripPrice, pricingStrategy, driverMatchingStrategy);
        tripList.add(trip);
        tripMetaDataList.add(tripMetaData);
    }

    public List<Trip> getTripList(){
        return tripList;
    }
}
