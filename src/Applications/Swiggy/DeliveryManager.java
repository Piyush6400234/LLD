package Applications.Swiggy;

import java.util.*;

public class DeliveryManager {
    private static DeliveryManager deliveryManager;

    private DeliveryManager(){}

    public static DeliveryManager getInstance(){
        if(deliveryManager == null){
            deliveryManager = new DeliveryManager();
        }
        return deliveryManager;

    }//This function should be broken down into sub parts and every method should have one small respinsibility
    public void manageDelivery(DeliveryMetaData deliveryMetaData){
        String orderId = deliveryMetaData.getOrderId();
        StrategyManager strategyManager = StrategyManager.getInstance();

        IDeliveryPartnerMatchingStrategy partnerMatchingStrategy = strategyManager.determineDeliveryPartnerMatchingStrategy(deliveryMetaData);
        List<DeliveryPartner> list = partnerMatchingStrategy.matchDeliveryPartners(deliveryMetaData);

        NotificationManager notificationManager = NotificationManager.getInstance();

        for(DeliveryPartner d: list){
            notificationManager.notifyParticularUser(d.getName(), "Delivery Request", new pushNotificationSender());
        }
        // this will be accepted by any one deliveryPartner and will proceed accordingly.
        DeliveryPartner assignedDeliveryPartner = list.get(0);
        notificationManager.notify(orderId, "Delovery partner "+ assignedDeliveryPartner.getName()+ " assigned for the order "+orderId);

        assignedDeliveryPartner.performDelivery(deliveryMetaData);



    }
}
