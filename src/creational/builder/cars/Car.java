package creational.builder.cars;
// We are not keeping methods in the car object, although we can define methods here and call them from builder as well.
public class Car implements Vehicle{
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
