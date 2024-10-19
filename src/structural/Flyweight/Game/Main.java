package structural.Flyweight.Game;

public class Main {
    public static void main(String[] args) {
        ProjectileFactory factory = new ProjectileFactory();
        Projectile bulletRed = factory.getProjectile("red", "redBullet.jpg", "bullet");
        Projectile missileRed = factory.getProjectile("red", "redMissile", "missile");
        Projectile missileRed2 = factory.getProjectile("red", "redMissile", "missile");
        bulletRed.render(2, 5, 66, 66);
        missileRed.render(3, 5,677, 766);
        missileRed2.render(76, 87, 8, 9);
    }
}
