package Applications.OnlineHotelBookingSystem.Payments;

public interface Payment {
    boolean processPayment(double amount);
}