package structural.bridge.shape;
/*

Problem:
We want to draw different shapes (like Circle and Square) using different drawing APIs (like OpenGL and DirectX).
Without the Bridge Pattern, this would require creating multiple classes for each combination of shape and drawing API.



Actual task of drawing will always be delegated to the implementation (here DrawingAPIs)
*/
public class Main {
    public static void main(String[] args) {
        DrawingAPI directx = new DirectxAPI();
        Circle circle = new Circle(2, 3, 8, directx);
        circle.draw();
        DrawingAPI openGL = new OpenGLAPI();
        Square square = new Square(5, 1, 98, openGL);
        square.draw();
    }
}
