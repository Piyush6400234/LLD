package creational.builder.cars;

import java.sql.SQLOutput;

public class CarBuilder implements Builder{
    private Car carr;

    public CarBuilder(){
        this.carr = new Car();
    }
//    We can also pass all these variables engine, body, wheels, Interior from director class.
    @Override
    public void buildEngine(){
        System.out.println("Building engine!!");
        this.carr.setEngine("My engine");
    }

    @Override
    public void buildBody(){
        System.out.println("Building Body!!");
        this.carr.setBody("My body");
    }

    @Override
    public void buildWheels(){
        System.out.println("Building Wheels!!");
        this.carr.setWheels("My Wheels");
    }

    @Override
    public void buildInterior(){
        System.out.println("Building Interior");
        this.carr.setInterior("My Interior");
    }
//    We can’t place a method for fetching results in the director without coupling the director to concrete product
//    classes. Hence, we obtain the result of the construction from the builder which performed the job.
    public Car getProduct(){
        return this.carr;
    }
}
