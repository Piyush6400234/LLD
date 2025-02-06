package Applications.OnlineHotelBookingSystem.Payments;

public class CashPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        // Process cash payment
        System.out.println("payment prcessed by cash");
        return true;
    }
}
