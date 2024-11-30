package Applications.Swiggy;

import java.util.List;

public class DishAddOn {
    private String name;
    private String description;
    private double price;
    private boolean isAvail;
    List<String> images;

    public DishAddOn(double price, String name) {
        this.price = price;
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
}
