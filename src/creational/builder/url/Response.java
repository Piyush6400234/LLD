package creational.builder.url;

import java.util.Map;

public class Response {
    private int statuscode;
    private Map<String, String> headers;
    private String body;

    public Response(int statuscode, Map<String, String> headers, String body){
        this.statuscode = statuscode;
        this.headers = headers;
        this.body = body;
    }
    public String getHeaderByKey(String key){
        return this.headers.get(key);
    }
    public String getBody(){
        return this.body;
    }
    public int getStatusCode(){
        return this.statuscode;
    }
}
