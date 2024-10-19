package Behavioral.Command.AirConditionerWithUndo;

import java.util.Stack;

public class Invoker {
    private Stack<Command> history;
    private Command command;

    public Invoker(Command command){
        history = new Stack<>();
        this.command = command;
    }

    public void pressButton(){
        if(command != null){
            command.execute();
            history.add(command);
        }
    }
    public void undo(){
        if(!history.isEmpty()){
            Command lastCommand = history.pop();
            lastCommand.undo();
        }
    }
}
