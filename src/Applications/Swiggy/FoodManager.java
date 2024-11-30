package Applications.Swiggy;
import java.util.*;
public class FoodManager {
    private static FoodManager foodManager;

    private FoodManager(){
//        foodManager = new FoodManager();
    }

    public static FoodManager getInstance(){
        if(foodManager == null){
            foodManager = new FoodManager();
        }
        return foodManager;
    }
    public void addRestaurantForNotificationUpdates(String orderId, String restaurantId){
        NotificationManager notificationMgr = NotificationManager.getInstance();
        notificationMgr.addNotificationSender(orderId, restaurantId, new pushNotificationSender());
    }
    public void prepareFood(String orderId, String restaurantId, Map<Dish, Integer> dishes){
        RestaurantManager restaurantMgr = RestaurantManager.getInstance();
        Restaurant restaurant = restaurantMgr.getRestaurant(restaurantId);
        restaurant.prepareFood(orderId, dishes);

        //Restaurant should receive the delivery partner's notifications.
        //The order in which the restaurant, user & delivery partner are added to the notification mgr
        //will decide which notifications they receive
        //For interviews, This is too much detailing though, we can just mention to interviewer and move forward
        addRestaurantForNotificationUpdates(orderId, restaurantId);
    }
}
