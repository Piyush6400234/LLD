package structural.decorator.notifiers;
/*
------------------  Decorator Pattern is used when we want to change an object Behaviour without much Inheritance ------------
This pattern has wrappers or Aggregation/composition at its core rather than Inheritance.
Eg. - Notification System, we have a notifier, and we inherit into whatsappNotifier, facebookNotifier or mailNotifier etc. or whatsapp+facebookNotifier

Better Approach - Use of Decorator pattern

======================== COMPONENTS OF DECORATOR PATTERNS =======================
1). COMPONENTS: The Component declares the common interface for both wrappers and wrapped objects.
2). CONCRETE COMPONENT: Concrete Component is a class of objects being wrapped. It defines the basic behavior, which
    can be altered by decorators.
3). BASE DECORATOR: The Base Decorator class has a field for referencing a wrapped object. The field’s type should be
    declared as the COMPONENT INTERFACE(2), so it can contain both concrete components and decorators. The base
    decorator delegates all operations to the wrapped object.
4). CONCRETE DECORATOR: Concrete Decorators define extra behaviors that can be added to components dynamically.
    Concrete decorators override methods of the base decorator and execute their behavior either before or after
    calling the parent method.
=================================================================================

Keep three things in mind - Notifier(concrete components), BaseDecorator(Abstract decorator)
and CustomDecorator(concrete decorator)
INotifier(component) is the single interface for both wrappers and wrapped objects.
Notifier is a basic notifier class. Notifier is the one that gets decorated(passed into decorators), using all the custom decorator classes.

We, now have an abstract Base Decorator class that will contain basic notifier class (Notifier) wrapper.
And we can inherit different Decorators from Base Decorator class that will implement send method differently.

Keeps going from customDecorator to BaseDecorator to CustomDecorator to Base Notifier
Whatsapp(Facebook(Notifier))
WhatsappNotifier's send -> BaseNotifier's send -> FacebookNotifier's send -> BaseNotifier's send to Notifier's send
*/
public class Main {
    public static void main(String[] args) {
        Notifier notifier = new Notifier("piyush");
        WhatsappDecorator whatsappAndDefault = new WhatsappDecorator(notifier);
//        whatsappAndDefault.send("new message");
        FacebookDecorator fbdecorator = new FacebookDecorator(whatsappAndDefault);
        fbdecorator.send("Hello.........");
    }
}
