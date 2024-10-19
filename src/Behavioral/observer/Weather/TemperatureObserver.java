package Behavioral.observer.Weather;

public class TemperatureObserver implements Observer{
    private float temperature;
    private String name;

    public TemperatureObserver(String name){
        this.name = name;
    }
    @Override
    public void update(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        display();
    }

    private void display(){
        System.out.println("Notified to: "+ name+" about temperature changed to: "+ temperature);
    }
}
