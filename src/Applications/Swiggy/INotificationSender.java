package Applications.Swiggy;

//This class corresponds to observer interface in the observer design pattern
//Notification Mgr is the subject

public interface INotificationSender {
    public void sendNotification(String userId, String msg);
}