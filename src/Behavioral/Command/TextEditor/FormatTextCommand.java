package Behavioral.Command.TextEditor;

public class FormatTextCommand implements TextEditorCommand{
    TextEditor textEditor;
    private String text;
    private String format;
    public FormatTextCommand(TextEditor textEditor, String text, String format){
        this.textEditor = textEditor;
        this.text = text;
        this.format = format;
    }
    @Override
    public void execute(){
        textEditor.formatText(text, format);
    }

}
