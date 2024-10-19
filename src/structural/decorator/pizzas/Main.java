package structural.decorator.pizzas;
/*

Imagine a coffee shop where you have different types of coffee and you can add various add-ons (like milk, sugar, or
whipped cream) to your coffee. You don't want to create a new class for every possible combination of coffee with
its add-ons. Instead, you use the Decorator Pattern to dynamically add extra features to your coffee.

*/
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        MilkDecorator milkcoffee = new MilkDecorator(coffee);
        System.out.println(milkcoffee.getDescription());
        System.out.println(milkcoffee.getCost());
    }
}
