package Behavioral.template.Bevarage;

public abstract class Beverage {
    // Concrete method: Boiling water is common steps that every algorithm will follow
    private void boilWater(){
        System.out.println("Boiling Water");
    }
    // Concrete method: common steps that every algorithm will follow
    private void pourInCup(){
        System.out.println("Pouring in Cup");
    }
    protected abstract void brew();
    protected abstract void addCondiments();


    // Template method defining the steps of the algorithm
    public final void prepareBeverage(){
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
}