package structural.bridge.pizzas;
/*
The Bridge pattern decouples an abstraction from its implementation so that the two can vary independently.
It is used to "bridge" the gap between an abstraction and its implementation by placing them in separate class hierarchies.
Particularly useful in scenarios where you need to separate the abstraction from its implementation to allow independent variations.

Abstraction: Defines the abstraction's interface and maintains a reference to an object of type Implementor.
Refined Abstraction: Extends the Abstraction class and provides additional features.
Implementor: Defines the interface for implementation classes.
Concrete Implementor: Implements the Implementor interface and provides concrete implementations.

The abstraction knows what needs to be done but leaves the "how" part to the implementor.
Use his when you have to change both "what" needs to be done and also change "how" it needs to be done. (Both independently.)

let's say we have a shape interface and its square and circle implements it. Also, there are two colors blue and red.
If we want to get all combinations we'll have redSquare, blueSquare, redCircle, blueCircle
Now , if we again want to add new type of color brown and one more shape triangle we'll have a total of 9 classes.
Problem: Here we are trying to extend the shapes into two dimensions, shapeType and shapeColors

Here comes the Bridge pattern for rescue.
The Bridge pattern attempts to solve this problem by switching from inheritance to the object composition.
What this means is that you extract one of the dimensions into a separate class hierarchy, so that the original classes
will reference an object of the new hierarchy, instead of having all of its state and behaviors within one class


Another example is Pizza:
Dimension one - Pizza type: veggie or Pepperoni implementor
Dimension two - Restaurant type: Italian or American abstractions

Restaurant will contain either veggie or Pepperoni pizza type
*/
public class Main {
    public static void main(String[] args) {
        Pizza veggie = new VeggiePizza(); // concrete Implementor.
        AmericanRestaurant amr = new AmericanRestaurant(veggie); // Refined abstraction.
        System.out.println(amr.getRestaurant());
        amr.addSauce();
        amr.addToppings();
        amr.makeCrust();
        amr.deliver();
    }
}
