package creational.factory.motor;
// Here object creation is delegated to subclasses(factories) of factoryClass

// For a single product family offering multiple products ex, a product family allows car and motor vehicle types.

// we define a product interface having a fixed set of methods, but we do not define the methods, because the method
// implementation may be different for different products.(car and motor)

// In CarProduct and motorProduct (implementing Product interface) we implement the methods of Product Interface,
// according to our needs.

// We then have an abstract factoryClass, which Declares the factory method, and returns an instance of the Product interface.
public class Main {
    public static void main(String[] args){
        System.out.println("hello");

        Product car = new carFactory().buildProduct();
        car.createProduct();
        car.buildProduct();
    }
}