package practice.Collections.fourth;

import Applications.StockBrokers.Order;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("phone list", phones);
        printData("email list", emails);


        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("phone contacs", phoneContacts);
        printData("email contacts", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        System.out.println(robinHood);

        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData("(A ∪ B) Union of emails (A) with phones (B)", unionAB);

        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts);
        printData("(A ∩ B) Intersect emails (A) and phones (B)", intersectAB);

        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts);
        printData("(B ∩ A) Intersect phones (B) and emails (A)", intersectBA);


        Set<Contact> AMinusB = new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts);
        printData("(A - B) emails (A) - phones (B)", AMinusB);

        Set<Contact> BMinusA = new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts);
        printData("(B - A) phones (B) - emails (A)", BMinusA);

        Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData("Symmetric difference: phones and emails ", symmetricDiff);


        Set<Contact> symmetricDiff2 = new HashSet<>(unionAB);
        symmetricDiff2.removeAll(intersectAB);
        printData("Symmetric difference: emails and phones ", symmetricDiff2);
        System.out.println("======================================================");
/*-------------------------------------- other Sets ----------------------------------------------------*/
//        NavigableSet<Contact> sorted = new TreeSet<>(phones); // Trows wrroe
        List<Contact> phones1 = ContactData.getData("phone");
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones1);
        sorted.forEach(System.out::println);

        NavigableSet<String> justNames = new TreeSet<>();
        phones1.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted); // set use sorting mechanism of sorting also of passed treeset
        fullSet.addAll(emails);
        System.out.println("-----------------fullset--------------------------");
        fullSet.forEach(System.out::println);

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("----------------------");
        fullList.forEach(System.out::println);


        Contact min = Collections.min(fullSet, mySort);
        Contact max = Collections.max(fullSet, mySort);
//        OR
//        Contact min = Collections.min(fullSet, fullSet.comparator());
//        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("==================================");
        System.out.printf("min = %s, first = %s %n", min.getName(), first.getName());
        System.out.printf("min = %s, first = %s %n", max.getName(), last.getName());



        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First ele = "+copiedSet.pollFirst());
        System.out.println("Last ele = "+copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-------------------------------");


        Contact daffy = new Contact("Daff Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for(Contact c: List.of(daffy, daisy, last, snoopy)){
            System.out.printf("celling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("-----------------");

        for(Contact c: List.of(daffy, daisy, first, archie)){
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }
        System.out.println("-----------------");

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("-----------------------------------");

        Contact lastContact = descendingSet.pollLast();
        System.out.println("Removed "+lastContact);

        descendingSet.forEach(System.out::println);
        System.out.println("------------------------------------");
        fullSet.forEach(System.out::println);
        System.out.println("--------------------------------");
        Contact marion = new Contact("Maid Marion");

        var headSet = fullSet.headSet(marion, false);
        headSet.forEach(System.out::println);
        System.out.println("----------------------------------");

        var tailSet = fullSet.tailSet(marion, true);
        tailSet.forEach(System.out::println);
        System.out.println("----------------------------------");

        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(linus, marion);
        subset.forEach(System.out::println);

    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-----------------------------------------");
        System.out.println(header);
        System.out.println("-----------------------------------------");
        contacts.forEach(System.out::println);
    }
}
