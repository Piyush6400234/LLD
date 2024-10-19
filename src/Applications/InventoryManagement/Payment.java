package Applications.InventoryManagement;

public class Payment {
    PaymentMode paymentMode;

    public Payment(PaymentMode mode){
        this.paymentMode = mode;
    }

    public boolean makePayment(){
        return paymentMode.makePayment();
    }
}
