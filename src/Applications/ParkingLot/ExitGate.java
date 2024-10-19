package Applications.ParkingLot;

public class ExitGate {
    private int exitTime = 5210; // ideally it should be timeStamp current
    public boolean removeTicket(Ticket ticket){
        boolean isProcessed = processPayment(ticket);
        ParkingSpotManager spotManager = ParkingSpotManagerFactory.getParkingSpotManager(ticket.getVehicle().getType());
        if(spotManager!= null)
            spotManager.removeVehicle(ticket.getVehicle());
        System.out.println("Removed vehicleId: "+ticket.getVehicle().getVehicleNo());
        // Logic should be such that both isProcessed and removeVehicle should get processed and then returned true.
        return true;
    }
    private boolean processPayment(Ticket ticket){
        // use current time and
        System.out.println("Payment processed for ticket id: "+ticket.getTicketId());
        int entryTime = ticket.getEntryTime();
        // and process payment
        // If payment successful return true else false
        return true;
    }

    // we can use a factory for cost calculator of two wheeler/four wheeler and process payment as needed.
}
