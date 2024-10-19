package structural.decorator.notifiers;

public class Notifier implements INotifier {
    private final String username;
    private final DatabaseService databaseService;

    public Notifier(String name){
        this.username = name;
        this.databaseService = new DatabaseService();
    }
    @Override
    public void send(String message){
        String mail = databaseService.getMailFromUsername(username);
        System.out.println("sending " + message + " by mail to " + mail);
    }
    @Override
    public String getUsername(){
        return this.username;
    }
}
