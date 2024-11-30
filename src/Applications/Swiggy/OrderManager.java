package Applications.Swiggy;

import java.util.*;

public class OrderManager {
    private static OrderManager orderManager;
    private List<Order> orders;
    private DeliveryManager deliveryManager;
    private FoodManager foodManager;

    private OrderManager(){
        orders = new ArrayList<>();
        deliveryManager = DeliveryManager.getInstance();
        foodManager = FoodManager.getInstance();
    }

    public static OrderManager getInstance(){
        if(orderManager == null){
            orderManager = new OrderManager();
        }
        return orderManager;
    }

    public void createOrder(Order order) {
        addUserForNotificationUpdates(order);
        manageFood(order);
        manageDelivery(order);
    }
    public void manageDelivery(Order order){
        DeliveryMetaData deliveryMetadata = new DeliveryMetaData(order.getUserLocation(), order.getRestaurantLocation(), order.getOrderId());
        deliveryManager.manageDelivery(deliveryMetadata);
    }
    public void manageFood(Order order){
//        we can pass a food MetaData also for better abstraction
        foodManager.prepareFood(order.getOrderId(), order.getRestaurantId(), order.getDishes());
    }
    public void addUserForNotificationUpdates(Order order){
        NotificationManager notificationMgr = NotificationManager.getInstance();
        notificationMgr.addNotificationSender(order.getOrderId(), order.getUserId(), new smsNotificationSender());
    }




}
