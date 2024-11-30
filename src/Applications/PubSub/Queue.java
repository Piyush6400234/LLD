package Applications.PubSub;

import java.util.*;
import java.util.UUID;

public class Queue {
    private Map<String, TopicHandler> topicProcessors = new HashMap<>();

    public Queue(){
        this.topicProcessors = new HashMap<>();
    }

    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler handler = new TopicHandler(topic);
        topicProcessors.put(topic.getId(), handler);
        return topic;
    }

    public void subscribe(Topic topic, ISubscriber subscriber) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getName());
    }

    public void publish(Message message, Topic topic) {
        topic.addMessage(message);
        System.out.println(message.getMsg() + " published to topic: " + topic.getName());
        new Thread(() -> topicProcessors.get(topic.getId()).publish()).start();
    }

    public void resetOffset(Topic topic,  ISubscriber subscriber,  Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubscriberList()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicProcessors.get(topic.getId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}