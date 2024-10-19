package Applications.InventoryManagement;

public class UPImode implements PaymentMode{
    @Override
    public boolean makePayment(){
        System.out.println("paying through UPI");
        return true;
    }
}
