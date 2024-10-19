package Behavioral.observer.Weather;

import javax.print.attribute.standard.JobStateReason;

/*
Also known as: EVENT-SUBSCRIBER or LISTENER

Two things -> 1). Publishers or Subjects and 2). Subscribers or Objects.

=========================================== : Core IDEAS: ===============================================
The Observer pattern suggests that you add a subscription mechanism to the publisher class so individual objects can
subscribe to or unsubscribe from a stream of events coming from that publisher.

This mechanism consists of:
1) an array field for storing a list of references to subscriber objects and
2) several public methods which allow adding subscribers to and removing them from that list.

Now, whenever an important event happens to the publisher, it goes over its subscribers and calls the specific
notification method on their objects.

Real apps might have dozens of different subscriber classes that are interested in tracking events of the same
publisher class. You would not want to couple the publisher to all of those classes. Besides, you might not even know
about some of them beforehand if your publisher class is supposed to be used by other people.

That’s why it’s crucial that all subscribers implement the same INTERFACE and that the publisher communicates with
them only via that interface. This interface should declare the notification method along with a set of parameters
that the publisher can use to pass some contextual data along with the notification.

Additionally, If your app has several different types of publishers, and you want to make your subscribers compatible
with all of them, you can go even further and make all publishers follow the same interface. This interface would only
need to describe a few subscription methods. The interface would allow subscribers to observe publishers’ states
without coupling to their concrete classes.

================================================= :COMPONENTS: =============================================
1). Subject (Observable): The object that holds the state and has one or more observers. The subject can be observed by
    multiple observers.
2). Observer: The object that wants to be informed when the subject's state changes. Each observer registers itself
    with the subject to be notified of updates.
3). Concrete Subject: The implementation of the subject, which holds state and notifies observers of any changes.
4). Concrete Observer: The implementation of the observer, which reacts to changes in the subject.


*/
public class Main {
    public static void main(String[] args) {
        Observer tempObserver1 = new TemperatureObserver("observer1");
        Observer tempObserver2 = new TemperatureObserver("observer2");
        Observer humidObserver1 = new HumidityObserver("observer3");
        WeatherStation weatherstation = new WeatherStation();
        weatherstation.registerObserver(tempObserver1);
        weatherstation.registerObserver(tempObserver2);
        weatherstation.registerObserver(humidObserver1);
        weatherstation.setWeatherData(2, 5, 1);
    }
}
/*
================================================ :Applicability: ===========================================
CASE: Use the Observer pattern when changes to the state of one object may require changing other objects, and the
    actual set of objects is unknown beforehand or changes dynamically.

SOLUTION: You can often experience this problem when working with classes of the graphical user interface. For example,
    you created custom button classes, and you want to let the clients hook some custom code to your buttons so that it
    fires whenever a user presses a button.
    The Observer pattern lets any object that implements the subscriber interface subscribe for event notifications in
    publisher objects. You can add the subscription mechanism to your buttons, letting the clients hook up their custom
    code via custom subscriber classes.

CASE:  Use the pattern when some objects in your app must observe others, but only for a limited time or in specific cases.

SOLUTION: The subscription list is dynamic, so subscribers can join or leave the list whenever they need to.

================================================= :Why Use the Observer Pattern?: ===============================
1). Decoupling of Components: The Observer Pattern decouples the subject (data provider) from the observers
    (data consumers). The subject does not need to know how the observers work or what they do with the data; it only
    knows that it has to notify them. This leads to more flexible and maintainable code.
2). Real-Time Notifications: The pattern is useful when you need real-time updates. Any number of observers can register
    themselves to the subject, and they’ll be updated immediately when the subject’s state changes.
3). Scalability: The Observer Pattern makes it easy to add or remove observers dynamically. You can have multiple
    displays or views without changing the subject's code.
4). Ensures Consistency: It helps ensure that all dependent objects are consistent with the state of the subject. For
    example, if the weather data changes, all connected displays are automatically updated.


*/