package Applications.BookMyShow;

public class Payment {
    int paymentId;
    Payment(int amount){
        this.paymentId = amount;
    }

    public void pay(){
        System.out.println("Paying "+ paymentId);
    }
}
