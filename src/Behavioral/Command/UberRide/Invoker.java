package Behavioral.Command.UberRide;

public class Invoker {
    Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void processCommand(){
        command.execute();
    }
}
