package creational.abstractFactory.Car;

public class AbstractFactoryProducer {
    public AbstractFactory factoryProducer(String type){
        if(type.equalsIgnoreCase("economic")){
            return new EconomicCarFactory();
        } else if (type.equalsIgnoreCase("luxury")) {
            return new LuxuryCarFactory();
        }
        return null;
    }
}
