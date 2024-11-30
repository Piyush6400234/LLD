package Applications.Swiggy;

import java.util.UUID;

public class User {
    private String name;
    private String id;
    private Location location;

    public User(String name, Location location) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.location = location;
    }
    public Location getLocation(){
        return location;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
}
