package structural.adapter.parser;
// Target class (Already existing)
public class XmlUser implements existingXmlUserInterf{
    @Override
    public void displayMenus(XmlData xmlData){
        System.out.println("Displaying Menus using xmlData");
        System.out.println("xmldata is: "+ xmlData.getText());
    }

    @Override
    public void displayRecommendations(XmlData xmlData){
        System.out.println("Displaying recommendations using xmlData");
        System.out.println("xmldata is: "+ xmlData.getText());
    }
}
