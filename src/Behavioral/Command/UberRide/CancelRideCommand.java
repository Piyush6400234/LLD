package Behavioral.Command.UberRide;

public class CancelRideCommand implements Command{
    RideService rideService;
    private String passenger;

    public CancelRideCommand(RideService rideService, String passenger){
        this.rideService = rideService;
        this.passenger = passenger;
    }

    @Override
    public void execute(){
        rideService.cancelRide(passenger);
    }
}
