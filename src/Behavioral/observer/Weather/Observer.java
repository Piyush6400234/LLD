package Behavioral.observer.Weather;

//The Observer interface defines the update() method that gets called when the subject's state changes.
public interface Observer {
    void update(float temperature, float humidity, float pressure);// for updating Observers, called by publishers.
}