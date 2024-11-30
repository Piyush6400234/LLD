package Applications.Swiggy;

public class smsNotificationSender implements INotificationSender{
    @Override
    public void sendNotification(String userId, String msg){
        System.out.println("Message sent to userId: "+userId+" Msg: "+msg);
    }
}
