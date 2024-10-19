package structural.bridge.pizzas;

public interface Pizza {
    public void setSauce(String s);
    public void setToppings(String s);
    public void setCrust(String s);
    public void assemble();
    public void qualityCheck();
}