package structural.decorator.notifiers;

public class WhatsappDecorator extends BaseNotifierDecorator{

    public WhatsappDecorator(INotifier notifier)
    {
        super(notifier);
    }
    @Override
    public void send(String msg){
        super.send(msg);// to send default method of Notifier class's object
        String phonenum = databaseService.getphonenumberFromUsername(this.getUsername());
        System.out.println("sending " + msg + " by WHatsapp on " + phonenum);
    }
}
