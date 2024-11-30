package Applications.PubSub;

public class SleepingSubscriber implements ISubscriber{
    private String id;
    private long sleepInTimeMillis;

    public SleepingSubscriber(String id, int sleepInTimeMillis) {
        this.id = id;
        this.sleepInTimeMillis = sleepInTimeMillis;
    }

    @Override
    public String getId() {
        return id;
    }
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getMsg());
//        try{
            Thread.sleep(sleepInTimeMillis);
//        }catch (Exception e){
//            System.out.println("something went wrong");
//
//        }

        System.out.println("Subscriber: " + id + " done consuming: " + message.getMsg());
    }
}
