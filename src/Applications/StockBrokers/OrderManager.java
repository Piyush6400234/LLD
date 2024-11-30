package Applications.StockBrokers;

public class OrderManager {
//    private static OrderManager orderManager;
    private OrderValidator orderValidator;
    private OrderExecutioner orderExecutioner;

    public OrderManager(){
        orderValidator = new OrderValidator();
        orderExecutioner = new OrderExecutioner();
    }

    public void placeOrder(User user, Order order){
        String userId = user.getId();
        if(orderValidator.validateOrder(userId, order)){
            orderExecutioner.executeOrder(order);
        }
        else {
            System.out.println("something went wrong, can't place order.");
        }
    }
}
