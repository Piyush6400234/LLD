package creational.factory.motor;

public abstract class factoryClass {
    public Product buildProduct(){
        Product yield = createProduct();
        return yield;
    }

    public abstract Product createProduct();
}
