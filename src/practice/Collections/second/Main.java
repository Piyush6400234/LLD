package practice.Collections.second;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');

        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray));


        /*----------------------- DOES NOT WORK -------------------------------*/
        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts); // this will replace cards element with passed object, but since cards is empty here this method only keeps cards empty
        System.out.println(cards);
        System.out.println("cards.size() = "+cards.size());
        // cards still empty
        /*---------------------------------------------------------------------*/


        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs); // if cards were empty list nothing would have happened
        // only half of it gets replaced
        Card.printDeck(cards, "Card Collection with Kings copied", 1);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

        Collections.shuffle(deck);
        Card.printDeck(deck, "reversed ", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck of Cards: ", 4);


        var sortingAlgorithm= Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);


        Collections.reverse(deck);
        Card.printDeck(deck, "sorted by rank, suit reversed:: ", 13);


        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(tens, "tens in deck", 1);

//        Collections.shuffle(deck);
        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = "+subListIndex);
        System.out.println("contains = "+deck.containsAll(tens));


        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = "+ disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = "+ disjoint2);

        deck.sort(sortingAlgorithm);
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int foundIndex = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("foundIndex = "+foundIndex);
        System.out.println("foundIndex = "+deck.indexOf(tenOfHearts));
        System.out.println(deck.get(foundIndex));

        Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
        Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
        Card.printDeck(deck.subList(32, 36), "Tends rows", 1);

        Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
        Card.printDeck(deck.subList(32, 36), "Tends rows", 1);

        if(Collections.replaceAll(deck, tenOfHearts, tenOfClubs)){
            System.out.println("Tens of Hearts replaced with tens of clubs");
        }
        else {
            System.out.println("No tens of Hearts found in the list");
        }


        System.out.println("Ten of clubs Cards = "+ Collections.frequency(deck, tenOfClubs));


        System.out.println("Best card = " + Collections.max(deck, sortingAlgorithm));
        System.out.println("Worst card = "+ Collections.min(deck, sortingAlgorithm));


        var SortBySuit = Comparator.comparing(Card::suit)
                .thenComparing(Card::rank);
        deck.sort(SortBySuit);
        Card.printDeck(deck, "Sorted by Suit, Rank", 4);

        List<Card> copied = new ArrayList<>(deck.subList(0, 13));
        Collections.rotate(copied, 2);
        System.out.println("UnRotated: "+ deck.subList(0, 13));
        System.out.println("Rotated: "+ 2+ ": "+copied);

    }
}
