package Applications.Swiggy;

import java.util.UUID;

public class DeliveryPartner extends Ipartner{
    private String id;
    public DeliveryPartner(String name){
        super(name);
        id = UUID.randomUUID().toString();
    }
    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public void setRating(int rating) {
        super.setRating(rating);
    }

    public String getId(){
        return id;
    }

    public void performDelivery(DeliveryMetaData deliveryMetaData){
        NotificationManager notificationManager = NotificationManager.getInstance();
        double restaurantLocLatitude = deliveryMetaData.getRestaurantLoc().getLatitude();
        double restaurantLocLongitude = deliveryMetaData.getRestaurantLoc().getLongitude();
        notificationManager.notify(deliveryMetaData.getOrderId(), super.getName()+" is going to pick up delivery from location "+ restaurantLocLatitude+", "+restaurantLocLongitude);
        notificationManager.notify(deliveryMetaData.getOrderId(), super.getName()+" picked up delivery");
        notificationManager.notify(deliveryMetaData.getOrderId(), " on the way to deliver");

        double userLocLatitude = deliveryMetaData.getUserLoc().getLatitude();
        double userLocLongitude = deliveryMetaData.getUserLoc().getLongitude();

        notificationManager.notify(deliveryMetaData.getOrderId(), " reached the location "+ userLocLatitude+", "+userLocLongitude);
    }
}