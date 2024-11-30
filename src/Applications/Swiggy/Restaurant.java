package Applications.Swiggy;

import java.util.*;

public class Restaurant {
    private String name;
    private boolean isAvail;
    private Location location;
    private Menu menu;
    private RestaurantOwner owner;
    private String id;

    public Restaurant(String name, boolean isAvail, Location location, RestaurantOwner owner) {
        this.name = name;
        this.isAvail = isAvail;
        this.location = location;
        this.owner = owner;
        this.id = UUID.randomUUID().toString();
    }
    public void addMenu(Menu menu){
        this.menu = menu;
    }
    public String getId(){
        return id;
    }
    public Location getLocation(){
        return this.location;
    }
    public Boolean prepareFood(String orderId, Map<Dish, Integer> dishes) {
        System.out.println("Restaurant accepting the order and starting to prepare it");
        NotificationManager notificationMgr = NotificationManager.getInstance();
        notificationMgr.notify(orderId, "Food is being prepared in restaurant");
        notificationMgr.notify(orderId, "Food is ready and can be picked up from restaurant");
        return true;
    }
}