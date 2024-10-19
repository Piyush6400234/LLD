package structural.adapter.parser;
// Adaptee class We could have it's interface as well if there were more variations needed.
public class JsonUser {
    public void displayMenus(JsonData jsonData){
        System.out.println("Displaying Menus using jsonData");
        System.out.println("jsonData is: " + jsonData.getText());
    }

    public void displayRecommendations(JsonData jsonData){
        System.out.println("Displaying recommendations using jsonData");
        System.out.println("jsonData is: " + jsonData.getText());
    }
}
