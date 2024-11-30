package Applications.PubSub;

public class SubscriberWorker implements Runnable{

    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(Topic topic, TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }


    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int curOffset = topicSubscriber.getOffset().get();
                while (curOffset >= topic.getMessageList().size()) {
                    try{
                        topicSubscriber.wait();
                    }
                    catch (Exception e){
                        Thread.currentThread().interrupt();
                        System.out.println("Thread was interrupted: " + e.getMessage());
                        return; // Exit the thread gracefully
                    }
                }
                Message message = topic.getMessageList().get(curOffset);
                try{
                    topicSubscriber.getSubscriber().consume(message);
                } catch(Exception e){
                    System.out.println("something went wrong");
                }
                // We cannot just increment here since subscriber offset can be reset while it is consuming. So, after
                // consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(curOffset, curOffset + 1);
            } while (true);
        }
    }

    synchronized public void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }

}
