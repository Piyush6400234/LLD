package Applications.snakeAndLadder;
import java.util.Random;
import java.util.stream.IntStream;


public class Dice {
    private int numberOfDice;

    public Dice(int numberOfDice){
        this.numberOfDice = numberOfDice;
    }
    int rollDice()
    {
        Random random = new Random();
        int sum = IntStream.range(0, this.numberOfDice).map(i -> random.nextInt(6) + 1).sum();

        //or sum = (int) (Math.random()*(6*numberOfDice - 1*numberOfDice)) +1; if numberOfDice = 2 range is 6*2 - 1*2
        return sum;
    }
}