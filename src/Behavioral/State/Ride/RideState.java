package Behavioral.State.Ride;

public interface RideState {
    void handleRequest();
    void cancelRequest();
}