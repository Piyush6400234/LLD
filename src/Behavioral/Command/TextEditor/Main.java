package Behavioral.Command.TextEditor;
/*
Consider a scenario where you have a text editor that needs to handle various editing operations like inserting text,
deleting text, and formatting text. Each of these operations can be represented as a command object that encapsulates
the specific action and any associated parameters.

Here we are not using any invoker because we'll have to pass various parameters to different commands.
Usually it should not be assigning any parameters then only invoker helps, or uniform parameters across all the Commands.
Here we'll directly use Main/Client.
*/
public class Main {
    public static void main(String[] args) {
        // Not using invoker here.
        TextEditor textEditor = new TextEditor("This is the initial text.");
        TextEditorCommand req1 = new InsertTextCommand(textEditor, "inserted", 3);
        req1.execute();
        TextEditorCommand req2 = new DeleteTextCommand(textEditor, "initial", 4, 12);
        req2.execute();

    }
}
