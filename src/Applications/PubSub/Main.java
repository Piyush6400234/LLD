package Applications.PubSub;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Topic topic1 = queue.createTopic("t1");
        Topic topic2 = queue.createTopic("t2");

        SleepingSubscriber sub1 = new SleepingSubscriber("sub1", 10000);
        SleepingSubscriber sub2 = new SleepingSubscriber("sub2", 10000);

        queue.subscribe(topic1, sub1);
        queue.subscribe(topic1, sub2);

        SleepingSubscriber sub3 = new SleepingSubscriber("sub3", 5000);
        queue.subscribe(topic2, sub3);
//
        queue.publish(new Message("m1"), topic1);
//        queue.publish(new Message("m2"), topic1);
//
//        queue.publish(new Message("m3"), topic2);
////        Thread.sleep(15000);
//
//        queue.publish(new Message("m4"), topic2);
//        queue.publish(new Message("m5"), topic1);
//
//        queue.resetOffset(topic1, sub1, 0);

    }
}
