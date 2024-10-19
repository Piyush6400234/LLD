package structural.decorator.pizzas;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription(){
        return coffee.getDescription()+" with sugar";
    }
    @Override
    public double getCost(){
        return coffee.getCost() + 2.0;
    }
}
