package Behavioral.observer.NewWithChannels;

public class NewsObserver implements Observer{
    private String name;
    private String message;

    public NewsObserver(String name){
        this.name = name;
    }

    @Override
    public void update(String news){
        this.message = news;
        displayMessage();
    }

    private void displayMessage(){
        System.out.println("Update received to name: "+name + " Update = "+ message);
    }


}
