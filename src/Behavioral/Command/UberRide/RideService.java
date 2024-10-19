package Behavioral.Command.UberRide;
// Receiver
public class RideService {
    public void requestRide(String passenger, String srcLoc, String dstLoc){
        System.out.println("Requesting a ride for: " + passenger + " from " + srcLoc + " to " + dstLoc);
    }
    public void cancelRide(String passenger){
        System.out.println("cancelling the ride for: "+passenger);
    }
}
