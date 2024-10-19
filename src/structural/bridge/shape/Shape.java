package structural.bridge.shape;
// Defining Abstraction
public abstract class Shape {
    DrawingAPI drawingAPI;

    public Shape(DrawingAPI drawingAPI){
        this.drawingAPI = drawingAPI;
    }
    public abstract void draw();
}
