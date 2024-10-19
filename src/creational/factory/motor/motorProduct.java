package creational.factory.motor;

public class motorProduct implements Product{
    public void createProduct(){
        System.out.println("Creating motorProduct");
    }
    public void buildProduct(){
        System.out.println("Building motorProduct");
    }
}
