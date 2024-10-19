package creational.abstractFactory.Furniture.Chair;

public class TraditionalChair implements Chair {
    @Override
    public void createChair(){
        System.out.println("Creating Traditional Chair");
    }
}
