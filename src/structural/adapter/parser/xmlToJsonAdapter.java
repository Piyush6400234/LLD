package structural.adapter.parser;

public class xmlToJsonAdapter extends XmlUser{
    public JsonUser jsonuser;
    public xmlToJsonAdapter(){
        this.jsonuser = new JsonUser();
    }
    @Override
    public void displayMenus(XmlData xmldata){
        JsonData converted = convertToJson(xmldata);
        jsonuser.displayMenus(converted);
    }
    @Override
    public void displayRecommendations(XmlData xmldata){
        JsonData converted = convertToJson(xmldata);
        jsonuser.displayRecommendations(converted);
    }

    public JsonData convertToJson(XmlData xmldata){

        //here goes the conversation logic
        System.out.println("converting xml to json");
        JsonData jd = new JsonData(xmldata.getText()+ " converted to json");
        return jd;
    }
}
