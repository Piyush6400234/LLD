package structural.bridge.pizzas;

public class AmericanRestaurant extends Restaurant{
    public AmericanRestaurant(Pizza pizza){
        super(pizza);
        this.restaurant = "American";
    }
    @Override
    public void addSauce(){
//        System.out.println("Adding sauce: sauce1 ");
        pizza.setSauce("sauce1"); // delegating low-level task (how-to) to implementor.
    }
    @Override
    public void addToppings(){
//        System.out.println("adding topping: topping1");
        pizza.setToppings("topping1"); // delegating low-level task (how-to) to implementor.

    }
    @Override
    public void makeCrust(){
//        System.out.println("adding crust: crust1");
        pizza.setCrust("crust1"); // delegating low-level task (how-to) to implementor.
    }
}
