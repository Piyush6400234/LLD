package Behavioral.observer.Weather;

public class HumidityObserver implements Observer{
    private float humidity;
    private String name;

    public HumidityObserver(String name){
        this.name = name;
    }

    @Override
    public void update(float temperature, float humidity, float pressure){
        this.humidity = humidity;
        display();
    }

    private void display(){
        System.out.println("Notified to: " + name + " about Humidity set to: " + humidity);
    }
}
