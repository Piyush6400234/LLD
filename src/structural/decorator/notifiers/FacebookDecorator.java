package structural.decorator.notifiers;

public class FacebookDecorator extends BaseNotifierDecorator {
    public FacebookDecorator(INotifier notifier)
    {
        super(notifier);
    }
    @Override
    public void send(String msg){
        super.send(msg);// to send default method of Notifier class's object we could have directly written wrappedd.send(msg) as well.
        String phonenum = databaseService.getphonenumberFromUsername(this.getUsername());
        System.out.println("sending " + msg + " by Facebook on " + phonenum);
    }
}