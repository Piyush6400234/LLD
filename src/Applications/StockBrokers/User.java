package Applications.StockBrokers;

import java.util.UUID;

public class User {
    private String name;
    private String id;
    //double funds;
    //List<Watchlist*> watchlists;
    //Portfolio* portfolio;

    public User(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
