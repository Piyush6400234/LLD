package structural.decorator.pizzas;
/*
Abstract Decorator:  This is the base class for all coffee decorators. It implements the Coffee interface and has a
reference to another Coffee object. It delegates calls to the wrapped object but can be extended to modify or
add behavior.
*/
public abstract class CoffeeDecorator implements Coffee{
    Coffee coffee; // The one that has to be decorated.

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
    public String getDescription(){
        return coffee.getDescription();
    }
    public double getCost() {
        return coffee.getCost();
    }
}
