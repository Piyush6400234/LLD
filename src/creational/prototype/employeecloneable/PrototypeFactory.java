package creational.prototype.employeecloneable;
import java.util.HashMap;
import java.util.Map;
public class PrototypeFactory {
    public static Map<String, Prototype> prototypes = new HashMap<>();

    public static Prototype getClone(String objType) throws CloneNotSupportedException{
        Prototype prototype = prototypes.get(objType);
        return prototype.clone();
    }
    public static void addPrototype(String objType, Prototype proto){
        prototypes.put(objType, proto);
    }
}