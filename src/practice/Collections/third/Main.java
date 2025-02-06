package practice.Collections.third;

import Applications.TicTacToe.Model.PlayingPiece;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        String aText = "Hello";
        String bText = "Hello";
        String cText = String.join("l", "He", "lo");
        String dText = "He".concat("llo");
        String eText = "hello";

        String[] newArr = new String[]{aText, bText, cText, dText, eText};
        List<String> hellos = Arrays.asList(newArr);


        hellos.forEach(s-> System.out.println(s+ ": "+ s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);

        System.out.println("mySet = "+ mySet);
        System.out.println("# of elements = "+mySet.size());
        System.out.println("-------------------------");

        for(String setValue: mySet){
            System.out.println(setValue+": ");
            for(int i = 0; i<hellos.size(); i++){
                if(setValue == hellos.get(i)){
                    System.out.println(i+", ");
                }
            }
            System.out.println(" ");
        }


        PlayingCard aceHearts = new PlayingCard("Hearts", "Ace");
        PlayingCard kingClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenSpades = new PlayingCard("Spades", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceHearts, kingClubs, queenSpades);
        cards.forEach(s-> System.out.println(s+": "+ s.hashCode()));


        Set<PlayingCard> deck = new HashSet<>();
        for(PlayingCard c: cards){
            if(!deck.add(c)){
                System.out.println("Found a duplicate for "+c);
            }
        }
        System.out.println(deck);



    }
}
