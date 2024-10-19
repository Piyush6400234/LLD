package Behavioral.observer.NewWithChannels;

public interface Subject {
    void registerObserver(String Channel, Observer obs);
    void removeObserver(String channel, Observer obs);
    void notifyObservers(String channel, String news);
}
