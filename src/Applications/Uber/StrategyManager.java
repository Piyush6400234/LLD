package Applications.Uber;

public class StrategyManager {
    private static StrategyManager strategyManager;

    private StrategyManager(){}
    public static StrategyManager getInstance(){
        if(strategyManager == null){
            strategyManager = new StrategyManager();
        }
        return strategyManager;
    }
    public PricingStrategy determinePricingStrategy(TripMetaData tripMetaData){
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new DefaultPricingStrategy();
    }
    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData tripMetaData){
        System.out.println("Based on location and other factors, setting matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }
}
