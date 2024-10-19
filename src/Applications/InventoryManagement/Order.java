package Applications.InventoryManagement;

import java.util.Map;

public class Order {
    public int orderId;
    public Cart cart;
    public User user;
    public Address deliveryAddress;
    public Warehouse warehouse;
    public Invoice invoice;
    public OrderStatus status;
    public boolean PaymentStatus;
    public double totalAmount;

    public Order(User user, Warehouse warehouse){
        this.user = user;
        this.orderId = (int)(Math.random()*9000 +1000);
        this.cart = user.cart;
        this.deliveryAddress = user.address;
        this.warehouse = warehouse;
        this.invoice = new Invoice();
        this.totalAmount = this.getTotal();
    }
    public void checkout(PaymentMode mode){

        boolean isPayment = this.makePayment(mode);

        if(isPayment){
            System.out.println("payment of "+this.totalAmount+" made");
            warehouse.removeItemFromInventory(cart.categoryVsCount);
            cart.emptyCart();
            status = OrderStatus.COMPLETED;
        }
    }
    public boolean makePayment(PaymentMode mode){
        Payment payment = new Payment(mode);
        return payment.makePayment();
    }
    public double getTotal(){
        double total = 0.0;
        for(Map.Entry<Integer, Integer> entry: cart.categoryVsCount.entrySet()){
            ProductCategory category = warehouse.inventory.getCategoryById(entry.getKey());
            total+= category.calculateTotal();
        }
        return total;
    }

    public Invoice generateInvoice(){
        this.invoice.showInvoiceDetail(this);
        return invoice;
    }
}
