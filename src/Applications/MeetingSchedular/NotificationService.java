package Applications.MeetingSchedular;
//NotificationService which will send notifications
public class NotificationService {
    public void sendNotification(User user, String message) {
        System.out.println("Sending notification to: " + user.getEmailId() + " " + message);
    }
}
