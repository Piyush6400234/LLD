package Applications.ParkingLot;

public class ExitGate {
    private int exitTime = 5210; // ideally it should be timeStamp current
    public boolean removeTicket(Ticket ticket, ParkingSpotManager spotManager){
        boolean isProcessed = processPayment(ticket);
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
}
