package creational.builder.url;
/*
Shreyansh jain has used this method.
 */
public class Main {
    public static void main(String[] args) {
        ResponseBuilder builder = new ResponseBuilder();
        Response response = builder.setStatusCode(200).addHeader("auth", "token").setBody("A new body in json format").build();
        System.out.println(response.getHeaderByKey("auth"));
    }
}
