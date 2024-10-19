package Applications.InventoryManagement;
import java.util.*;

public class UserController {
    List<User> userList;

    public UserController(){
        this.userList = new ArrayList<>();
    }

    public void addUser(User user){
        this.userList.add(user);
    }

    public void removeUser(User user){
        this.userList.remove(user);
    }

    public User getUserById(int userId){
        for(User user: userList){
            if(user.userId == userId){
                return user;
            }
        }
        return null;
    }
}