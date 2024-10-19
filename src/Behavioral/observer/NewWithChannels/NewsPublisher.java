package Behavioral.observer.NewWithChannels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsPublisher implements Subject{
    public Map<String, List<Observer>> observers;

    public NewsPublisher(){
        this.observers = new HashMap<>();
    }

    @Override
    public void registerObserver(String channel, Observer obs){
        observers.putIfAbsent(channel, new ArrayList<>());
        observers.get(channel).add(obs);
    }
    @Override
    public void removeObserver(String channel, Observer obs){
        List<Observer>observer = observers.get(channel);
        if(observer != null){
            observer.remove(obs);
        }
    }

    @Override
    public void notifyObservers(String channel, String news){
        List<Observer> observer = observers.get(channel);
        if(observer != null){
            System.out.println("Update posted to channel: " + channel+" news: "+news);
            for(Observer obs: observer){
                obs.update(news);
            }
        }
    }
    public void publishNews(String channel, String news){
        notifyObservers(channel, news);
    }

}