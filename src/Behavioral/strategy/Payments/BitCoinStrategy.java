package Behavioral.strategy.Payments;
// The pay method will contain algorithms specific to Bitcoin payment.
public class BitCoinStrategy implements PaymentInterface{
    private String walletAddress;

    public BitCoinStrategy(String walletAddress){
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount){
//        algorithms specific to Bitcoin payment
        System.out.println("Paying through BitCoinStrategy using walletAddress: "+walletAddress+", amount: "+amount);
    }

}
