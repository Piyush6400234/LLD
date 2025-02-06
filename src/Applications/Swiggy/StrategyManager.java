package Applications.Swiggy;

public class StrategyManager {
    private static StrategyManager strategyManager;

    private StrategyManager(){}

    public static StrategyManager getInstance(){
        if(strategyManager == null){
            strategyManager = new StrategyManager();
        }
        return strategyManager;
    }
    IDeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetaData deliveryMetaData){
        System.out.println("Based on location, weather and other factors, setting partner strategy");
        return new LocBasedDeliveryPartnerMatchingStrategy();
    }
}