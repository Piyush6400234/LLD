package Applications.InventoryManagement;
import java.util.*;


public class OrderController {
    List<Order> orderList;
    Map<Integer, List<Order>> userVsOrder;

    public OrderController(){
        this.orderList = new ArrayList<>();
        this.userVsOrder = new HashMap<>();
    }

    public Order createOrder(User user, Warehouse warehouse){
        Order newOrder = new Order(user, warehouse);

        if(userVsOrder.containsKey(user.userId)){
            List<Order> t = userVsOrder.get(user.userId);
            t.add(newOrder);
            userVsOrder.put(user.userId, t);
        }
        else{
            List<Order> t = new ArrayList<>();
            t.add(newOrder);
            userVsOrder.put(user.userId, t);
        }
        return newOrder;
    }
    public List<Order> getOrderByUserId(int userId){
        return userVsOrder.getOrDefault(userId, new ArrayList<>());
    }
}
