package Behavioral.Command.TextEditor;

public class DeleteTextCommand implements TextEditorCommand{
    TextEditor textEditor;
    private String text;
    private int start;
    private int end;

    public DeleteTextCommand(TextEditor textEditor, String text, int start, int end){
        this.textEditor = textEditor;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute(){
        textEditor.deleteText(text, start, end);
    }
}
