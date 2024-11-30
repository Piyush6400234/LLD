package Applications.PubSub;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private final String id;
    private final String name;
    private List<Message> messageList;
    private List<TopicSubscriber> subscriberList;

    public Topic(String name, String id) {
        this.id = id;
        this.name = name;
        this.messageList = new ArrayList<>();
        this.subscriberList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public List<TopicSubscriber> getSubscriberList() {
        return subscriberList;
    }
    public void addSubscriber(TopicSubscriber sub){
        subscriberList.add(sub);
    }
    public synchronized void addMessage(Message message){
        messageList.add(message);
    }
}
