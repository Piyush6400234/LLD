package structural.bridge.shape;

public class Square extends Shape{
    double x;
    double y;
    double radius;

    public Square(double x, double y, double radius, DrawingAPI drawingAPI){
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(){
        drawingAPI.drawSquare(x, y, radius);
    }
}