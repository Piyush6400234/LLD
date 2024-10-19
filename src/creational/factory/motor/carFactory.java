package creational.factory.motor;

public class carFactory extends factoryClass{

    @Override
    public Product createProduct(){
        return new carProduct();
    }
}
