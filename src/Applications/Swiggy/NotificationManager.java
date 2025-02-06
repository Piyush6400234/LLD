package Applications.Swiggy;


import java.util.*;

public class NotificationManager {
    private static NotificationManager notificationManager;
    private Map<String, List<Pair>> map;

    private NotificationManager(){
        map = new HashMap<>();
    }
    public static NotificationManager getInstance(){
        if(notificationManager == null){
            notificationManager = new NotificationManager();
        }
        return notificationManager;
    }

    public void  addNotificationSender(String orderId, String userId, INotificationSender notificationSender){
        if(map.get(orderId)!=null){
            List<Pair> plist= map.get(orderId);
            for(Pair p: plist){
                if(p.getUserId().equals(userId) && p.getSender() instanceof  pushNotificationSender){
                    return;
                }
            }
        }
        if(map.get(orderId) == null){
            map.put(orderId, new ArrayList<>());
        }
        Pair p = new Pair(userId, notificationSender);
        map.get(orderId).add(p);
    }

    public void notify(String orderId, String msg){
        for(Pair s: map.get(orderId)){
            System.out.println("notify.............");
            s.getSender().sendNotification(s.getUserId(), msg);
        }
    }
    public void notifyParticularUser(String userId, String msg, INotificationSender sender){
        sender.sendNotification(userId, msg);
    }

}
