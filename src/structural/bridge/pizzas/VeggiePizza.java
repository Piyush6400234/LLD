package structural.bridge.pizzas;

public class VeggiePizza implements Pizza{
    protected String sauce;
    protected String toppings;
    protected String crust;

    @Override
    public void setSauce(String sauce){
        this.sauce = sauce;
    }
    @Override
    public void setToppings(String toppings){
        this.toppings = toppings;
    }
    @Override
    public void setCrust(String crust){
        this.crust = crust;
    }

    @Override
    public void assemble(){
        System.out.println("Adding sauce " + sauce);
        System.out.println("adding toppings " + toppings);
        System.out.println("adding Veggie");
    }

    @Override
    public void qualityCheck(){
        System.out.println("adding crust " + this.crust);
    }
}
