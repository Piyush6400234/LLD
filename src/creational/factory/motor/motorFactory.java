package creational.factory.motor;

public class motorFactory extends factoryClass{

    @Override
    public Product createProduct(){
        return new motorProduct();
    }
}
