package practice.Immutables.fifth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainMailer {
    public static void main(String[] args) {
        String[] names = {"Ann Jones", "Ann Jones Ph.D.", "Bob Jones M.D", "Carol Jones", "Ed Green Ph.D.", "Ed Green M.D",
                            "Ed Black"};

        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);
        });
        System.out.println("-".repeat(50));
        System.out.println(counts);
        StringBuilder annJonesPhd = new StringBuilder("Ann Jones Ph.D.");
        System.out.println("-".repeat(50));
        System.out.println("There are "+counts.get(annJonesPhd) + " records for "+annJonesPhd);


        List<StringBuilder> cleanedNames = standardizeNames(population);
        System.out.println("-".repeat(50));
        System.out.println(cleanedNames);
        System.out.println("-".repeat(50));
        System.out.println("There are "+counts.get(annJonesPhd) + " records for "+annJonesPhd);

        System.out.println(counts);
        System.out.println("-".repeat(50));
        StringBuilder annJones= new StringBuilder("Ann Jones");
        System.out.println("There are "+counts.get(annJones) + " records for "+annJones);
        System.out.println("-".repeat(50));



        counts.forEach((k, v)-> System.out.println(k+" : "+v)); // gives different result

        System.out.println("-".repeat(50));

        counts.forEach((k, v)-> System.out.println(k+" : "+counts.get(k))); // than above sout


    }

    private static List<StringBuilder> getNames(String[] names){
        List<StringBuilder> list = new ArrayList<>();
        int index = 3;
        for(String name: names){
            for(int i = 0; i<index; i++){
                list.add(new StringBuilder(name));
            }
            index++;
        }
        System.out.println(list);
        return list;
    }

    private static List<StringBuilder> standardizeNames(List<StringBuilder> list){
        List<StringBuilder> newList = new ArrayList<>();

        for(var name: list){
            for(String suffix: new String[]{"Ph.D.", "M.D"}){
                int startINd = -1;
                if((startINd = name.indexOf(suffix)) > -1){
                    name.replace(startINd-1, startINd+suffix.length(), "");
                }
            }
            newList.add(name);
        }
        return newList;
    }
}
