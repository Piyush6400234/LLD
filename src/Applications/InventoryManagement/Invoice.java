package Applications.InventoryManagement;

public class Invoice {
    public String userName;
    public double totalAmount;
    public Order order;
    public int invoiceId;

    public Invoice(){
    }
    public void showInvoiceDetail(Order order){
        this.userName = order.user.userName;


        System.out.println("user: "+userName + " InvoiceID: "+invoiceId+" totalAmount: "+order.getTotal());
        System.out.println("Product Details: ");
        for(int key : order.cart.categoryVsCount.keySet()){
            System.out.println("categoryId: "+ key+", count: "+ order.cart.categoryVsCount.get(key));
        }
    }
}