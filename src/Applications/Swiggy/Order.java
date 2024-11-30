package Applications.Swiggy;

import java.util.*;
import java.util.UUID;

public class Order {
    private String orderId;
    private User user;
    private Restaurant restaurant; // we can choose to store only ids of user and restaurant for further decoupling.
    // We are assuming that a dish is separate from the same dish with addon.
    // There are many ways to store dishes that are being ordered, but
    // we should know our design assumptions properly
    private Map<Dish, Integer> dishes;
    private String discountCode;
    private String paymentId;
    private OrderStatus status;

    public Order(User user, Restaurant restaurant, Map<Dish, Integer> dishes, String discountCode, String paymentId, OrderStatus status) {
        this.user = user;
        this.restaurant = restaurant;
        this.dishes = dishes;
        this.discountCode = discountCode;
        this.paymentId = paymentId;
        this.status = status;
        this.orderId = UUID.randomUUID().toString();
    }

    public String getOrderId(){
        return this.orderId;
    }
    public Location getUserLocation(){
        return user.getLocation();
    }
    public Location getRestaurantLocation(){
        return restaurant.getLocation();
    }
    public String getRestaurantId(){
        return restaurant.getId();
    }
    public Map<Dish, Integer> getDishes(){
        return dishes;
    }
    public String getUserId(){
        return user.getId();
    }

}
