package creational.builder.cars;

public class Director {
    public Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public void createVehicle(){
        if(builder instanceof BikeBuilder){
            buildBike();
        }
        if(builder instanceof CarBuilder){
            buildCar();
        }
    }


    private void buildBike(){
        this.builder.buildBody();
        this.builder.buildWheels();
        this.builder.buildEngine();
    }
    private void buildCar(){
        this.builder.buildBody();
        this.builder.buildEngine();
        this.builder.buildInterior();
    }
}
