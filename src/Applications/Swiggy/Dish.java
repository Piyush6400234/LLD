package Applications.Swiggy;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private CuisineType cuisine;
    private String description;
    private double price;
    private List<String> dishImages;
    private List<DishAddOn> dishAddOns;

    public Dish(String name, CuisineType cuisine, String description, double price) {
        this.name = name;
        this.cuisine = cuisine;
        this.description = description;
        this.price = price;
        this.dishImages = new ArrayList<>();
        this.dishAddOns = new ArrayList<>();
    }
    public void addAddon(DishAddOn addOn){
        this.dishAddOns.add(addOn);
    }
    public double getPrice(){
        double total = price;
        for(DishAddOn d: dishAddOns){
            total+= d.getPrice();
        }
        return  total;
    }
    private String getDescription() { return description; }
    private String getDishName() { return name; }
    private CuisineType getCuisine() { return cuisine; }
}
