package practice.Collections.fourth;

import java.util.*;

public class MapViewsMain {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();


        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if(contacts.containsKey("Linus Van Pelt")){
            System.out.println("Linus and I go way back, so of course I have info");
        }

        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k, v)-> System.out.println(v));

        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k, v)-> System.out.println(v));

        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k, v)-> System.out.println(v));

        keysView.clear();
        System.out.println(contacts);

//        keysView.add("Daffy Duck"); // error -> Unsupported operation on keyView
//        System.out.println(contacts);

        ContactData.getData("email").forEach(c-> contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c-> contacts.put(c.getName(), c));
        System.out.println(keysView);
        System.out.println("-----------------------------------------");
        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k, v)-> System.out.println(v));
        System.out.println("-----------------------------");
        var nodeSet = contacts.entrySet();
        for(var node: nodeSet){
            System.out.println(nodeSet.getClass().getName());
            System.out.println(node.getClass().getName());
            if(!node.getKey().equals(node.getValue().getName())){
                System.out.println("Key doesn't match name: "+node.getKey()+": "+node.getValue());
            }
        }

    }
}
