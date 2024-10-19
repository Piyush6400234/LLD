package Behavioral.Command.AirConditionerWithUndo;
/*
Design A.C with turnOn/turnOff feature and should have undo functionality.
*/
public class Main {
    public static void main(String[] args) {
        AC ac = new AC();
        Command turnOnCommand = new turnOnCommand(ac);
        Invoker invoker = new Invoker(turnOnCommand);
        invoker.pressButton();
        invoker.undo();
    }
}