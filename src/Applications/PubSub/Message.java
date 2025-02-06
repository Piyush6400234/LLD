package Applications.PubSub;

public class Message {
    public Message(String msg) {
        this.msg = msg;
    }

    private final String msg;

    public String getMsg() {
        return msg;
    }
}
