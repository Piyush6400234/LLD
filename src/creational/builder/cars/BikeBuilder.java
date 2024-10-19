package creational.builder.cars;

import Behavioral.Iterator.AmazonInventory.Product;

public class BikeBuilder implements Builder{
    Bike bike;

    public BikeBuilder(){
        this.bike = new Bike();
    }
    @Override
    public void buildEngine(){
        bike.setEngine("new engine");
    }
    @Override
    public void buildBody(){
        bike.setBody("new body");
    }
    @Override
    public void buildWheels(){
        bike.setWheels("new Wheels");
    }
    @Override
    public void buildInterior(){
        bike.setInterior("new Interior");
    }

    public Bike getProduct(){
        return this.bike;
    }
}
