package Behavioral.observer.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }
    @Override
    public void removeObserver(Observer obs){
        observers.remove(obs);
    }

    @Override
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(temperature, humidity, pressure);
        }
    }
    // Set the weather data and notify observers
    public void setWeatherData(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        System.out.println("Update published");
        notifyObservers();
    }
}
