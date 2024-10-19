package creational.abstractFactory.Car;

public class LuxuryCarFactory implements AbstractFactory{

    @Override
    public Car getCar(int price){
        if(price<2500){
            return new LuxuryCar1();
        }
        else{
            return new LuxuryCar2();
        }
    }
}
