package Applications.Swiggy;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static UserManager userManager;
    List<User> userList;
    private UserManager(){
        userList = new ArrayList<>();
    }

    public static UserManager getInstance(){
        if(userManager == null){
            userManager = new UserManager();
        }
        return userManager;
    }
    public void addUser(User user){
        this.userList.add(user);
    }
    public User getUser(String Id){
        for(User u: userList){
            if(u.getId().equals(Id)){
                return u;
            }
        }
        return null;
    }
}
