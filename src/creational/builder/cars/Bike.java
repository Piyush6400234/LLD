package creational.builder.cars;

public class Bike implements Vehicle{
    private String engine;
    private String body;
    private String wheels;
    private String interior;

    public void setEngine(String engine){
        this.engine = engine;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setWheels(String wheel){
        this.wheels = wheel;
    }
    public void setInterior(String interior){
        this.interior = interior;
    }
    public String getEngine(){
        return this.engine;
    }
}
