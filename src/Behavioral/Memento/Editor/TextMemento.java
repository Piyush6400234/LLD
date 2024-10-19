package Behavioral.Memento.Editor;
// Memento: Stores the state of the TextEditor
public class TextMemento {
    private final String text;

    public TextMemento(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

}
