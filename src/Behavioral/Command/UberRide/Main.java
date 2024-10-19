package Behavioral.Command.UberRide;

public class Main {
    public static void main(String[] args) {
        RideService rideService = new RideService();
        Command request1 = new RideRequestCommand(rideService, "Piyush", "Bangalore", "Darbhanga");
        Invoker invoker = new Invoker();
        invoker.setCommand(request1);
        invoker.processCommand();
    }
}
