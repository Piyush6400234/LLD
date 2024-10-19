package creational.abstractFactory.Car;

public class EconomicCarFactory implements AbstractFactory{
    @Override
    public Car getCar(int price){
        if(price<1200){
            return new EconomicCar1();
        }
        else{
            return new EconomicCar2();
        }
    }
}
