package Applications.Logger;

public class FileLogger implements LogObserver{
    @Override
    public void log(String msg){
        System.out.println("write to file: "+ msg);
    }
}
