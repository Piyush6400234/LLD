package Behavioral.State.Ride;

public class Ride {
    RideState rideState;

    public Ride(){
        this.rideState = new RideRequestedState();
    }

    public void setRideState(RideState rideState){
        this.rideState = rideState;
    }

    public void requestState(){
        this.rideState.handleRequest();
    }

    public void cancelState(){
        this.rideState.cancelRequest();
    }
}
