package structural.bridge.pizzas;

public abstract class Restaurant {
    protected Pizza pizza;
    protected String restaurant;

    protected Restaurant(Pizza pizza){
        this.pizza = pizza;
    }
    abstract void addSauce(); // Methods that define what to do, it will delegate the how-to task to implementor.
    abstract void addToppings(); // Methods that define what to do, it will delegate the how-to task to implementor.
    abstract void makeCrust(); // Methods that define what to do, it will delegate the how-to task to implementor.

    public void deliver(){
        makeCrust();
        addToppings();
        addSauce();
        pizza.assemble();
        pizza.qualityCheck();
        System.out.println("Order in Progress!!");
    }
    public String getRestaurant(){
        return this.restaurant;
    }
}
