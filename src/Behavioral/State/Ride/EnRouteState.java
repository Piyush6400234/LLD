package Behavioral.State.Ride;

public class EnRouteState implements RideState{

    @Override
    public void handleRequest(){
        System.out.println("Ride is already En route!!");
    }

    @Override
    public void cancelRequest(){
        System.out.println("Ride request cannot be cancelled, while the driver is En route!!");
    }

}
