package Applications.CarRental;
import java.util.*;
// paymentDetails can't exist without Bill
public class PaymentDetails {
    int paymentID;
    int amountPaid;
    Date dateOfPayment;
    boolean isRefundable;
    PaymentMode paymentMode;

    public PaymentDetails(int amount, PaymentMode mode, boolean isRefundable){
        this.paymentID = (int)(Math.random()*1000);
        this.amountPaid = amount;
        this.paymentMode = mode;
        this.dateOfPayment = new Date();
        this.isRefundable = isRefundable;
    }
    public void showDetails(){
        System.out.println("payment ID: "+ paymentID);
        System.out.println("amount Paid: "+ amountPaid);
        System.out.println("Date of payment: "+ dateOfPayment);
        System.out.println("Payment Mode: "+ paymentMode.name());
        System.out.println("refundable Type: "+ isRefundable);
    }
}
