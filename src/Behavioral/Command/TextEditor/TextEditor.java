package Behavioral.Command.TextEditor;
// Receiver
public class TextEditor {
    private String docText;
    public TextEditor(String doc){
        this.docText = doc;
    }

    public void insertText(String text, int pos){
        String newString = this.docText.substring(0, pos+1)+text+this.docText.substring(pos+1);
        this.docText = newString;
        System.out.println("String inserted: "+text+", New String: "+this.docText);
    }

    public void deleteText(String text, int start, int end){
        StringBuilder newString = new StringBuilder(this.docText);
        newString.delete(start, end);
        this.docText = newString.toString();
        System.out.println("Modified string: "+this.docText);
    }

    public void formatText(String text, String format){
        System.out.println("Formatted text: "+text+" with format: "+format);
    }

    public String getDocText(){
        return this.docText;
    }
}