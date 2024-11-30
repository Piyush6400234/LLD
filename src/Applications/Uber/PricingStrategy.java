package Applications.Uber;

public interface PricingStrategy {
    double calculatePrice(TripMetaData tripMetaData);

}
