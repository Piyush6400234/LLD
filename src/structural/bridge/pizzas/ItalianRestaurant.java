package structural.bridge.pizzas;

public class ItalianRestaurant extends Restaurant{

    public ItalianRestaurant(Pizza pizza){
        super(pizza);
        this.restaurant = "Italian";
    }
    @Override
    public void addSauce(){
//        System.out.println("adding sauce: sauce2");
        pizza.setSauce("sauce2"); // delegating low-level task (how-to) to implementor.
    }
    @Override
    public void addToppings(){
//        System.out.println("adding topping: topping2");
        pizza.setToppings("topping2"); // delegating low-level task (how-to) to implementor.

    }
    @Override
    public void makeCrust(){
//        System.out.println("adding crust: crust2");
        pizza.setCrust("crust2"); // delegating low-level task (how-to) to implementor.
    }
}
