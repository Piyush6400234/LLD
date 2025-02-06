package Applications.Swiggy;

import java.util.*;

public class LocBasedDeliveryPartnerMatchingStrategy implements IDeliveryPartnerMatchingStrategy{
    @Override
    public List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData deliveryMetaData){
        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getInstance();
        System.out.println("Quadtrees can be used to get nearest delivery partners, "
                + "Delivery partner manager can be used to get details of partners. "
                +"Returning all delivery partners for demo purposes for now.");

        List<DeliveryPartner> nearestDeliveryPartners = new ArrayList<>();

        for(DeliveryPartner d: deliveryPartnerMgr.getALlDeliveryPartner()){
            nearestDeliveryPartners.add(d);
        }
        return nearestDeliveryPartners;
    }
}
