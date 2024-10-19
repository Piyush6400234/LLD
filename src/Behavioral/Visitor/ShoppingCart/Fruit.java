package Behavioral.Visitor.ShoppingCart;

public class Fruit implements ItemElement{
    private int pricePerKg;
    private int weight;
    private String name;
    public Fruit(int pricePerKg, int weight, String name){
        this.name = name;
        this.pricePerKg = pricePerKg;
        this.weight = weight;
    }
    @Override
    public int accept(ShoppingCartVisitor visitor){
        return visitor.visit(this);
    }
    public int getPricePerKg(){
        return this.pricePerKg;
    }
    public int getWeight(){
        return this.weight;
    }
    public String getName(){
        return this.name;
    }
}