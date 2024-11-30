package Applications.Swiggy;

import java.util.*;

public class DeliveryPartnerMgr {
    private static DeliveryPartnerMgr deliveryPartnerMgr;
    private List<DeliveryPartner> deliveryPartnerList;

    private DeliveryPartnerMgr(){
        deliveryPartnerList = new ArrayList<>();
    }

    public static DeliveryPartnerMgr getInstance(){
        if(deliveryPartnerMgr == null){
            deliveryPartnerMgr = new DeliveryPartnerMgr();
        }
        return deliveryPartnerMgr;
    }
    public void addDeliveryPartner(DeliveryPartner d){
        deliveryPartnerList.add(d);
    }
    public DeliveryPartner getDeliveryPartner(String partnerId){
        for(DeliveryPartner d: deliveryPartnerList){
            if(d.getId().equals(partnerId)){
                return d;
            }
        }
        return null;
    }
    public List<DeliveryPartner> getALlDeliveryPartner(){
        return deliveryPartnerList;
    }


}
