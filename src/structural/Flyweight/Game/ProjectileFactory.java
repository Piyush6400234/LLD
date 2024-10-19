package structural.Flyweight.Game;

import java.util.HashMap;
import java.util.Map;

public class ProjectileFactory {
    public static final Map<String, Projectile> mp = new HashMap<>();

    public Projectile getProjectile(String color, String sprite, String type){
        type = type.toLowerCase();
        String key = color+", "+", "+sprite+", "+type;
        Projectile projectile = mp.get(key);

        if(projectile == null){
            System.out.println("Creating new "+ type + " with color: " + color + " and sprite: " + sprite);
            switch (type) {
                case "bullet":
                    projectile = new Bullet(color, sprite);
                    break;
                case "missile":
                    projectile = new Missile(color, sprite);
                    break;
                case "shrapnel":
                    projectile = new Shrapnel(color, sprite);
                    break;
            }
            mp.put(key, projectile);
        }
        else{
            System.out.println(type + " already Present with color: " +color+" and sprite: "+sprite);
        }

        return projectile;
    }

}
