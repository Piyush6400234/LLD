package Behavioral.State.Ride;

public class DriverAssignedState implements RideState{
    @Override
    public void handleRequest(){
        System.out.println("Ride is assigned to driver!!");
    }

    @Override
    public void cancelRequest(){
        System.out.println("Ride has been canceled. The driver is notified!!");
    }
}
