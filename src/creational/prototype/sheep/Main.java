package creational.prototype.sheep;
// In prototype pattern we have a product Interface that declares cloning method, concrete product class that implements
// cloning method, and a client/Application class. An object that supports cloning is called a prototype.
// Method-1: Using traditional new keyword for cloning.

public class Main {
    public static void main(String[] args) {

        Sheep white = new WhiteSheep("white_sheep");
        Sheep black = new BlackSheep("black_sheep");
        System.out.println(white.getName());
        Sheep newWhite = white.clone();
        newWhite.setName("newWhite");
        System.out.println(newWhite.getName());
    }
}