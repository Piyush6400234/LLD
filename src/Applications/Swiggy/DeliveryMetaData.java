package Applications.Swiggy;

public class DeliveryMetaData {
    private Location userLoc;
    private Location restaurantLoc;
    private String orderId;

    public DeliveryMetaData(Location userLoc, Location restaurantLoc, String orderId) {
        this.userLoc = userLoc;
        this.restaurantLoc = restaurantLoc;
        this.orderId = orderId;
    }

    public Location getUserLoc(){
        return this.userLoc;
    }

    public Location getRestaurantLoc(){
        return this.restaurantLoc;
    }
    public String getOrderId(){
        return orderId;
    }
}
