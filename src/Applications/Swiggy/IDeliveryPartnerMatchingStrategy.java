package Applications.Swiggy;

import java.util.List;

public interface IDeliveryPartnerMatchingStrategy {
     List<DeliveryPartner> matchDeliveryPartners(DeliveryMetaData deliveryMetaData);
}