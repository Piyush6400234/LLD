package Behavioral.strategy.Payments;
// The pay method will contain algorithms specific to Paypal payment.
public class PayPalStrategy implements PaymentInterface{
    private String email;

    public PayPalStrategy(String email){
        this.email = email;
    }

    @Override
    public void pay(int amount){
        // algorithms specific to Paypal payment
        System.out.println("Paying through PayPalStrategy using email: "+email+", amount: "+amount);
    }
}