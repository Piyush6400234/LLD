package Behavioral.State.Ride;

public class Main {
    public static void main(String[] args) {
        Ride ride = new Ride();
        ride.requestState();
        ride.cancelState();

        // changing state to driver assigned state
        ride.setRideState(new DriverAssignedState());
        ride.requestState();
        ride.cancelState();

        // changing state to EnRoute state
        ride.setRideState(new EnRouteState());
        ride.requestState();
        ride.cancelState();
    }
}
