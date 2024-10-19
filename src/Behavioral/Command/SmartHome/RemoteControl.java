package Behavioral.Command.SmartHome;
// Invoker Class: RemoteControl
public class RemoteControl {
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}