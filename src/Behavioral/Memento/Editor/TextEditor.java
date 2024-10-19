package Behavioral.Memento.Editor;
// Originator: TextEditor that creates and restores its memento
public class TextEditor {
    private String text = "";

    public void writeText(String text){
        this.text+= text;
    }
    public String getText(){
        return this.text;
    }
    public TextMemento save(){
        return new TextMemento(text);

    }
    public void restore(TextMemento memento){
        this.text = memento.getText();
    }

    public void showText(){
        System.out.println("Current text is; "+text);
    }
}