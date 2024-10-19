package structural.bridge.shape;
// Concrete Implementor - Actual Drawing will be done by this Class, and these task will be delegated by
// abstractions(here circle and square class)
public class DirectxAPI implements DrawingAPI{
    public void drawCircle(double x, double y, double radius) {
        System.out.println("drawing circle using DirectxAPI at x: "+ x+ "y:"+y+ " with radius: "+ radius);
    }
    public void drawSquare(double x, double y, double radius) {
        System.out.println("drawing square using DirectxAPI at x: "+ x+ "y:"+y+ " with radius: "+ radius);
    }
}
