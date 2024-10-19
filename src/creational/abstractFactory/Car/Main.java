package creational.abstractFactory.Car;

/*
Here there are two factors, one is price and another is economic/Luxury.
On the basis of economic/luxury we will get a corresponding factory, and after that we can use price as a criteria
to get car1/car2
 */

public class Main {
    public static void main(String[] args) {
        AbstractFactory ecomomicFactory = new AbstractFactoryProducer().factoryProducer("economic");
        Car car1 = ecomomicFactory.getCar(2000);
        System.out.println(car1.getTopSpeed());
    }
}