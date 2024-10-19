package structural.bridge.shape;

public class OpenGLAPI implements DrawingAPI{
    public void drawCircle(double x, double y, double radius){
        System.out.println("drawing circle using OPENGL at x: "+ x+ "y: "+y+ " with radius: "+ radius);
    }
    public void drawSquare(double x, double y, double radius){
        System.out.println("Drawing square using OPENGL at x: "+ x+ "y: "+y+ " with radius: "+ radius);
    }
}