package Applications.OnlineHotelBookingSystem.Payments;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        // Process credit card payment
        System.out.println("Payment processed by credit card");
        return true;
    }
}