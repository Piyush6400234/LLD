package Behavioral.Command.TextEditor;

public class InsertTextCommand implements TextEditorCommand{
    TextEditor textEditor;
    private String text;
    private int pos;

    public InsertTextCommand(TextEditor textEditor, String text, int pos){
        this.textEditor = textEditor;
        this.text = text;
        this.pos = pos;
    }

    @Override
    public void execute() {
        textEditor.insertText(text, pos);
    }
}
