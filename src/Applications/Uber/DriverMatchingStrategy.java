package Applications.Uber;

public interface DriverMatchingStrategy {
    Driver matchDriver(TripMetaData tripMetaData);
}
