package creational.builder.url;
import java.util.HashMap;
import java.util.Map;
public class ResponseBuilder {
    public int statuscode;
    public Map<String, String > headers = new HashMap<>();
    public String body = "";

    public ResponseBuilder setStatusCode(int statuscode){
        this.statuscode = statuscode;
        return this;
    }
    public ResponseBuilder setBody(String body){
        this.body = body;
        return this;
    }
    public ResponseBuilder addHeader(String key, String value){
        this.headers.put(key, value);
        return this;
    }
    public Response build(){
        return new Response(this.statuscode, this.headers, this.body);
    }
}
