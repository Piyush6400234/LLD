package Behavioral.Memento.Editor;
/*
Also Known as: Snapshot
Memento: The Memento Design Pattern is a behavioral design pattern that allows an object to capture its internal state
    at a given time so that it can later be restored to that state. The main idea is to provide a way to undo changes
    to an object's state without exposing its internal details/implementation.
============================================= :IDEA: ====================================================
The Memento pattern delegates creating the state snapshots to the actual owner of that state, the originator object.

The pattern suggests storing the copy of the object’s state in a special object called memento. The contents of the
memento aren’t accessible to any other object except the one that produced it.

Other objects must communicate with mementos using a limited interface which may allow fetching the snapshot’s
metadata (creation time, the name of the performed operation, etc.), but not the original object’s state contained
in the snapshot.

Such a restrictive policy lets you store mementos inside other objects, usually called caretakers. Since the caretaker
works with the memento only via the limited interface, it’s not able to tamper with the state stored inside the memento.
At the same time, the originator has access to all fields inside the memento, allowing it to restore its previous
state at will.
A stack of mementos stored inside the caretaker will grow each time the editor is about to execute an operation.

=========================================== :PROBLEMS IT SOLVES: ==========================================
The Memento pattern solves the problem of saving and restoring the state of an object without exposing its internal
structure. It’s useful when an object's state changes over time, and you need to restore the previous state without
breaking encapsulation.
============================================== :COMPONENTS: ===============================================
1). ORIGINATOR: This is the object whose state needs to be saved. It can create a Memento(snapshots ) to store its
    current state and restore its state from a Memento when needed.
2). MEMENTO: The Memento is a value object that acts as a snapshot of the originator’s state. It’s a common practice
    to make the memento immutable and pass it the data only once, via the constructor.
3). CARETAKER: A caretaker can keep track of the originator’s history by storing a stack of mementos. When the
    originator has to travel back in history, the caretaker fetches the topmost memento from the stack and passes it to
    the originator’s restoration method.


================================================== :USE CASE: ===============================================
we create a simple text editor where the user can type text and undo their previous actions.

*/
public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();
        history.save(editor);
        editor.writeText("Hello, ");
        editor.showText();
        history.save(editor);

        editor.writeText("world!");
        editor.showText();
        history.undo(editor);
        editor.showText();
    }
}