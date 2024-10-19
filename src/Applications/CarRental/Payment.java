package Applications.CarRental;
// payments can't exist without Bill
public class Payment {

    public PaymentDetails makePayments(int amount, PaymentMode mode, boolean isRefundable, String cardDetails){
        System.out.println("Paying: "+amount);
        System.out.println("card Details: "+cardDetails);
        PaymentDetails detail = new PaymentDetails(amount, mode, isRefundable);
        return detail;
    }
}
