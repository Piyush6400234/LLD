package Applications.Swiggy;

public class Pair {
    private String id;
    private INotificationSender sender;

    public Pair(String id, INotificationSender notificationSender){
        this.id = id;
        this.sender = notificationSender;
    }
    public String getUserId(){
        return id;
    }

    public INotificationSender getSender(){
        return sender;
    }

}
