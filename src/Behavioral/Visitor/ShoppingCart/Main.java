package Behavioral.Visitor.ShoppingCart;
/*
-- Visitor is a behavioral design pattern that lets you separate Methods from the objects on which they operate.
-- It is used when you have a structure of objects, and you want to perform various operations on these objects without
    changing their classes.
-- The main idea behind the Visitor pattern is that instead of defining the operations inside the objects, you define
    them in separate visitor classes. The objects accept visitors, which then perform the operations.

The Visitor pattern suggests that you place the new behavior into a separate class called visitor, instead of trying to
integrate it into existing classes. The original object that had to perform the behavior is now passed to one of the
visitor’s methods as an argument, providing the method access to all necessary data contained within the object.

-------------------------------------- :COMPONENTS OF VISITOR PATTERNS: --------------------------------------------
1). Visitor Interface: The Visitor interface declares a set of visiting methods that can take concrete elements of an
    object structure as arguments. These methods may have the same names if the program is written in a language that
    supports overloading, but the type of their parameters must be different.
2). Concrete Visitors: Each Concrete Visitor implements several versions of the same behaviors, tailored for different
    concrete element classes.
3). Element Interface: The Element interface declares a method for “accepting” visitors. This method should have one
    parameter declared with the type of the visitor interface.
4). Concrete Elements: Each Concrete Element must implement the acceptance method. The purpose of this method is to
    redirect the call to the proper visitor’s method corresponding to the current element class. Be aware that even
    if a base element class implements this method, all subclasses must still override this method in their own classes
    and call the appropriate method on the visitor object.

-------------------------------------------------- :CRUX: ----------------------------------------------------
The main logic of cost calculation/particular method is placed in the concrete visitor class, and not in the object itself.
------------------------------------------------ :USE CASE: --------------------------------------------------
Let's say we have a shopping cart with items like Book and Fruit. Each item has different pricing logic based on its
properties. We can use the Visitor pattern to define pricing logic without changing the classes of the items.
 */
public class Main {
    public static void main(String[] args) {
        Book book = new Book(60, "8765ty7899jh");
        Fruit fruit = new Fruit(40, 2, "Guava");
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int cost = visitor.visit(book);
        System.out.println("Cost is: "+cost);
        cost = visitor.visit(fruit);
        System.out.println("Fruit cost is: "+cost);
    }
}