package Behavioral.strategy.Payments;
// The pay method will contain algorithms specific to credit card payment.
public class CreditCardStrategy implements PaymentInterface{
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardStrategy(String cardNumber, String cardHolderName){
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(int amount){
        // algorithms specific to credit card payment
        System.out.println("Paying through Credit Card using card number: "+cardNumber +", to cardHolder: "+cardHolderName+", amount: "+amount);
    }
}
