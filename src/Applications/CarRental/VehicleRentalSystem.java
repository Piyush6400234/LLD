package Applications.CarRental;
import java.util.*;
public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    public VehicleRentalSystem(List<Store> storeList, List<User> userList){
        this.storeList = storeList;
        this.userList = userList;
    }

    public void addUser(User user){
        this.userList.add(user);
    }
    public void addStore(Store store){
        this.storeList.add(store);
    }

    public void removeStore(Store store){
        this.storeList.remove(store);
    }
    public void removeUser(User user){
        this.userList.remove(user);
    }

    public List<Store> getStores(Location location){
        // filter out Stores based on location
        List<Store> filteredStore = new ArrayList<>();
        for(Store s: this.storeList){
            if(s.getLocation() == location){
                filteredStore.add(s);
            }
        }
        return filteredStore;
    }

    public Store getStoreByLocation(Location location){
        for(Store s: storeList){
            if(s.getLocation() == location){
                return s;
            }
        }
        return null;
    }
}