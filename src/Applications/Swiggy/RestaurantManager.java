package Applications.Swiggy;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    private static RestaurantManager restaurantManager;
    private List<Restaurant> restaurantList;
    private RestaurantManager(){
        restaurantList = new ArrayList<>();
    }

    public static RestaurantManager getInstance(){
        if(restaurantManager == null){
            restaurantManager = new RestaurantManager();
        }
        return restaurantManager;
    }
    public void addRestaurant(Restaurant restaurant){
        restaurantList.add(restaurant);
    }
    public Restaurant getRestaurant(String restaurantId){
        for(Restaurant r: restaurantList){
            if(r.getId().equals(restaurantId)){
                return r;
            }
        }
        return null;
    }

}
