package structural.decorator.pizzas;
/*
Concrete Component:
This is the base class that implements the Coffee interface. It represents a plain coffee without any add-ons.
*/
public class SimpleCoffee implements Coffee{

    public String getDescription() {
        return "Simple Coffee";
    }

    public double getCost() {
        return 5.50;
    }
}
