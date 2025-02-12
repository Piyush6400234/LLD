package practice.Collections.fourth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-------------------");

        Map<String, Contact> contacts = new HashMap<>();

        for(Contact contact: fullList){
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v)-> System.out.println("key= "+k + ", value= "+v));
        System.out.println("-----------------------------------");
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));
        System.out.println("------------------------------------");


        contacts.clear();

        for(Contact contact: fullList){
            Contact duplicate = contacts.put(contact.getName(), contact);
            if(duplicate !=null){
//                System.out.println("duplicate = "+duplicate);
//                System.out.println("current = "+contact);
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v)-> System.out.println("Key = "+k+", Value= "+v));


        System.out.println("------------------------------------------");
        contacts.clear();

        for(Contact contact: fullList){
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v)-> System.out.println("key= "+k+", value= "+v));

        System.out.println("------------------------------------------");
        contacts.clear();

        for(Contact contact: fullList){
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if(duplicate != null){
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v)-> System.out.println("key= "+k+", value= "+v));

        System.out.println("-------------------------------------------");

        for(String contactName: new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            contacts.compute(contactName, (k, v)->new Contact(k));
        }

        contacts.forEach((k, v)-> System.out.println("Key= "+ k + ", value= "+v));
        System.out.println("---------------------");

        for(String contactName: new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            contacts.computeIfAbsent(contactName, k -> new Contact(k));
        }

        contacts.forEach((k, v)-> System.out.println("Key= "+ k + ", value= "+v));

        for(String contactName: new String[]{"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            contacts.computeIfPresent(contactName, (k, v) -> {v.addEmail("Fun Place"); return v;
            });
        }

        contacts.forEach((k, v)-> System.out.println("Key= "+ k + ", value= "+v));
        System.out.println("-".repeat(50));


        contacts.replaceAll((k, v)-> {
            String newEmail = k.replaceAll(" ", "") + "@funplace.com";
            v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
            return v;
        });

        contacts.forEach((k, v)-> System.out.println("Key= "+ k + ", value= "+v));



    }
}
