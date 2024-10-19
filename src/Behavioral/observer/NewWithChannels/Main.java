package Behavioral.observer.NewWithChannels;
/*
In this case:
The Publisher (subject) would have multiple channels, and each observer can choose to subscribe to one or more channels.
The Observer can register to specific channels and only get updates from those channels.

================================= :How to Implement Channels in the Observer Pattern: =============================
Channels: Introduce the concept of channels or topics that represent different streams of updates. Each channel will
have its own set of observers.

Subscription to Specific Channels: Observers can subscribe to multiple channels and receive updates only from those
channels they are subscribed to.
*/
public class Main {
    public static void main(String[] args) {
        Observer obs1 = new NewsObserver("obsever1");
        Observer obs2 = new NewsObserver("observer2");
        Observer obs3 = new NewsObserver("observer3");

        NewsPublisher publisher1 = new NewsPublisher();
        publisher1.registerObserver("channel1", obs1);
        publisher1.registerObserver("channel1", obs2);
        publisher1.registerObserver("channel2", obs3);

        publisher1.notifyObservers("channel1", "Modi resigns at 75!");
        publisher1.notifyObservers("channel2", "BJP appoints Yogi as next PM!");

    }
}
