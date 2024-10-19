package structural.decorator.notifiers;

public abstract class BaseNotifierDecorator implements INotifier{
    private final INotifier wrapped;
    protected final DatabaseService databaseService; // we could have skipped it, since the wrapped object already has databaseService
    public BaseNotifierDecorator(INotifier notifier){
        this.wrapped = notifier;
        databaseService = new DatabaseService();
    }
    @Override
    public void send(String message){
        wrapped.send(message);
    }
    @Override
    public String getUsername(){
        return wrapped.getUsername();
    }
}
