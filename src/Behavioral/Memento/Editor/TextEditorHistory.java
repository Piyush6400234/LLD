package Behavioral.Memento.Editor;
import java.util.Stack;
// Caretaker: Manages saving and restoring the states (mementos)
public class TextEditorHistory {
    private final Stack<TextMemento> history = new Stack<>();

    public void save(TextEditor textEditor){
        history.add(textEditor.save());
    }

    public void undo(TextEditor editor){
        if(!history.isEmpty()){
            editor.restore(history.pop());
        }
        else{
            System.out.println("No previous state to restore!");
        }
    }
}