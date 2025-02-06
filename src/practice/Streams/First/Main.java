package practice.Streams.First;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int counter = 0;
    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);
        int start = 1;
        for(char c: "BINGO".toCharArray()){
            for(int i = start; i<(start+15); i++){
                bingoPool.add(""+c+i);
//                System.out.println(""+c+i);
            }
            start+=15;
        }

        Collections.shuffle(bingoPool);
        for(int i = 0; i<15; i++){
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(50));
//        List<String > firstOnes = bingoPool.subList(0, 15);
        List<String > firstOnes = new ArrayList<>(bingoPool.subList(0, 15));
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {

            if(s.indexOf('G') == 0 || s.indexOf("O") == 0){
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(updated+" ");
                return updated;
            }
            return s;
        });
        System.out.println("-".repeat(50));

        for(int i = 0; i<15; i++){
            System.out.println(bingoPool.get(i));
        }
        System.out.println("-".repeat(50));

        /*-----------------------------------------using streams ------------------------------------------*/
//        bingoPool.stream().limit(15).filter(s-> s.indexOf('G') == 0 || s.indexOf("O") == 0)
//                .map(s -> s.charAt(0)+"-"+s.substring(1))
//                .sorted()
//                .forEach(s -> System.out.println(s+" "));
//
//        System.out.println("-".repeat(50));
//        for(int i = 0; i<15; i++){
//            System.out.println(bingoPool.get(i));
//        }
//        System.out.println("-".repeat(50));

        var tempStream = bingoPool.stream().limit(15).filter(s-> s.indexOf('G') == 0 || s.indexOf("O") == 0)
                .map(s -> s.charAt(0)+"-"+s.substring(1))
                .sorted();
        tempStream.forEach(s-> System.out.println(s+" ")); // the tempStream code above will not get executed untill/before this line
        System.out.println("-".repeat(50));

//        tempStream.forEach(s -> System.out.println(s.toLowerCase()+ " ")); // not allowed

        String[] strings = {"One", "Two", "Three"};
        var firstStream = Arrays.stream(strings)
                .sorted(Comparator.reverseOrder());
//                .forEach(System.out::println);

        var secondStream = Stream.of("Six", "Five", "Four")
                .map(String::toUpperCase);
//                .forEach(System.out::println);
        Stream.concat(secondStream, firstStream)
                .map(s-> s.charAt(0)+" - "+s)
                .forEach(System.out::println);


        Map<Character, int[]> myMap = new LinkedHashMap<>();
        int bingoIndex = 1;
        for(char c: "BINGO".toCharArray()){
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers, i->i+labelNo);
            myMap.put(c, numbers);
            bingoIndex+=15;
        }
        System.out.println("-".repeat(50));

        myMap.forEach((k, v)-> System.out.println("Key: "+k+", value: "+ Arrays.toString(v)));

        myMap.entrySet()
                .stream()
                .map(e->e.getKey() + " has range: " + e.getValue()[0] + " - "+e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);
        /* -------------------------------------- Infinite stream but with a limit of 10 ------------------*/
        Random random = new Random();
        Stream.generate(() -> random.nextInt(2)).limit(10)
                .forEach(s-> System.out.print(s+" "));


        System.out.println();
        IntStream.iterate(1, n-> n+1)
                .filter(Main::isPrime)
                .limit(20)
                .forEach(s-> System.out.print(s+ " "));

        System.out.println();
        IntStream.iterate(1, n-> n+1)
                .limit(100)
                .filter(Main::isPrime)
                .forEach(s-> System.out.print(s+ " "));


        System.out.println();
        IntStream.iterate(1, n-> n<=100, n-> n+1)
                .filter(Main::isPrime)
                .forEach(s-> System.out.print(s+ " "));

        System.out.println();
        IntStream.range(1, 100)
                .filter(Main::isPrime)
                .forEach(s-> System.out.print(s+ " "));


        System.out.println("-".repeat(50));
        int seed = 15;
        int pseed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "N" + (pseed+i));

        var streamN = Arrays.stream(oLabels);

        int nseed = seed+15;
        var streamG = Stream.of("G46", "G47", "G48", "G49", "G50", "G51", "G52", "G53", "G54", "G55"
                    , "G56", "G57", "G58", "G59", "G60");

        seed+=15;
        int rseed = seed;

        var streamO = Stream.generate(Main::getCounter)
                        .limit(15)
                                .map(i -> "O" + (rseed+i));
        streamO.forEach(System.out::println);


        Stream.generate(() -> new Random().nextInt(rseed, rseed+15))
                .distinct()
                .limit(15)
                .map(i-> "O"+i).sorted()
                .forEach(System.out::println);





    }

    private static int getCounter(){
        return counter++;
    }

    public static boolean isPrime(int wholeNumber){
        if(wholeNumber <= 2){
            return (wholeNumber == 2);
        }

        for(int divisor = 2; divisor<wholeNumber; divisor++){
            if(wholeNumber%divisor == 0){
                return false;
            }
        }
        return true;
    }
}
