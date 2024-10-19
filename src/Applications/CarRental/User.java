package Applications.CarRental;

public class User {
    int userId;
    String userName;
    int drivingLicence;

    public int getUserId(){
        return this.userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setUserName(String name){
        this.userName = name;
    }
    public int getDrivingLicence(){
        return drivingLicence;
    }
    public void setDrivingLicence(int drivingLicence){
        this.drivingLicence = drivingLicence;
    }
}