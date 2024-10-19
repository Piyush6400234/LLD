package structural.decorator.notifiers;
// Component - common interface of both wrappers and wrapped objects.
public interface INotifier {
    void send(String message);
    String getUsername();
}