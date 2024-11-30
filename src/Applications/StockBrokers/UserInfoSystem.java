package Applications.StockBrokers;

import java.util.ArrayList;
import java.util.List;

public class UserInfoSystem {
    private static UserInfoSystem userInfoSystem;
    private List<User> userList;

    private UserInfoSystem() {
        this.userList = new ArrayList<>();
    }

    public static UserInfoSystem getInstance(){
        if(userInfoSystem == null){
            userInfoSystem = new UserInfoSystem();
        }
        return userInfoSystem;
    }
    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(String id){
        for(User u: userList){
            if(u.getId().equals(id)){
                return u;
            }
        }
        return null;
    }

    public void showAllUser(){
        for(User u: userList){
            System.out.println("Name "+ u.getName()+ " id: "+u.getId());
        }
    }
}
