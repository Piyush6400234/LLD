package creational.factory.motor;

public class carProduct implements Product{
    public void createProduct(){
        System.out.println("creating carProduct");
    }
    public void buildProduct(){
        System.out.println("building carProduct");
    }
}
