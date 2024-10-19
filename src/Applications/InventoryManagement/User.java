package Applications.InventoryManagement;
import java.util.*;
public class User {
    int userId;
    String userName;
    List<Integer> orderList;
    Cart cart;
    Address address;

    public User(String UserName){
        this.userName = UserName;
        this.orderList = new ArrayList<>();
        this.cart = new Cart();
    }

    public void addCategory(int categoryId, int count){
        this.cart.addCategory(categoryId, count);
    }
    public void removeCategory(int categoryId, int count){
        this.cart.removeCategory(categoryId, count);
    }

    public void addOrder(int orderId){
        this.orderList.add(orderId);
    }
}