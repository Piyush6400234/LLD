package structural.bridge.shape;

public class Circle extends Shape{
    double x;
    double y;
    double radius;

    public Circle(double x, double y, double radius, DrawingAPI drawingAPI){ // or we can just pass drawingAPI and
        // pass x, y, radius in draw method directly from main
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw(){
        drawingAPI.drawCircle(this.x, this.y, this.radius);
    }
}
