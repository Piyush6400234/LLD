package Behavioral.strategy.Payments;
// The context doesn't know about current strategy being used, instead client passes it. It exposes a single method.
//The context class (e.g., PaymentContext) is responsible for interacting with different payment strategies. It holds a
// reference to a PaymentStrategy object, which it can switch at runtime.
// There should not be any constructor because the variable attribute(paymentStrategy) will be changed dynamicallyat runtime.
// This is the core objective of strategy pattern.
public class PaymentContext {
    private PaymentInterface paymentStrategy; // This should never be final, this will be changed dynamically
    public void setPaymentStrategy(PaymentInterface paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(int amount){
        if(paymentStrategy == null){
            System.out.println("Please select a payment strategy!!");
        }
        else {
            paymentStrategy.pay(amount);
        }
    }
}
