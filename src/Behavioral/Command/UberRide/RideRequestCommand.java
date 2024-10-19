package Behavioral.Command.UberRide;
// concrete command
public class RideRequestCommand implements Command{
    RideService rideService;
    private String passenger;
    private String srcLoc;
    private String dstLoc;

    public RideRequestCommand(RideService rideService, String passenger, String srcLoc, String dstLoc){
        this.rideService = rideService;
        this.passenger = passenger;
        this.srcLoc = srcLoc;
        this.dstLoc = dstLoc;
    }

    @Override
    public void execute(){
        rideService.requestRide(passenger, srcLoc, dstLoc);
    }
}