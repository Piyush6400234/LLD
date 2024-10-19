package structural.decorator.pizzas;
/*
Concrete Decorators: These decorators extend the CoffeeDecorator and add extra functionality (in this case, add-ons
like milk, sugar, or whipped cream). Each of them overrides the getDescription() and getCost() methods to add their
specific behavior.
 */
public class MilkDecorator extends CoffeeDecorator{
    public MilkDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription() + " With milk";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 2.0;
    }
}
