package Behavioral.State.Ride;

public class RideRequestedState implements RideState{
    @Override
    public void handleRequest(){
        System.out.println("Ride has been requested!!");
    }

    @Override
    public void cancelRequest(){
        System.out.println("Ride request has been canceled!!");
    }
}
