package structural.Flyweight.Game;

public class Shrapnel implements Projectile{
    private final String color;
    private final String sprite;

    public Shrapnel(String color, String sprite){
        this.color = color;
        this.sprite = sprite;
    }
    @Override
    public void render(int x, int y, int vector, int speed){
        System.out.println("Rendering Bullet with color: "+color + " sprite: "+sprite+" at X: "+x+ " , y: "+ y+
                " vector: "+vector + " speed: "+ speed);
    }
}