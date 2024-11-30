package practice.Collections.first;

import java.util.*;
/*
<<List>>, <<Set>>, <<Queue>> all  are interface derived from <<Collection>>

LinkedList and ArrayList are implementation of <<List>>
HashSet and LinkedHashSet are implementation of <<Set>> --------> <<SortedSet>> is derived from <<Set>> and implemented by TreeSet

<<Deque>> is derived by <<Queue>> and ArrayDeque and LinkedList are implementations of <<Deque>>


*/

public class Main {
    public static void main(String[] args) {
        Collection<String> list = new HashSet<>();

        String[] names = {"Anna", "Bob", "Carol", "David", "Edna"};
        list.addAll(Arrays.asList(names));

        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George", "Gray", "Grace"));
        System.out.println(list);

        System.out.println("Gray is in the list ?:"+ list.contains("Gray"));

        list.removeIf(s-> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Gray is in the list ?: "+ list.contains("Gray"));

    }
}
