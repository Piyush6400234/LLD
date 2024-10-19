package Behavioral.template.Bevarage;

public class Coffee extends Beverage{

    @Override
    protected void brew(){
        System.out.println("Brewing the Coffee grounds");
    }

    @Override
    protected void addCondiments(){
        System.out.println("Adding sugar and milk");
    }
}
