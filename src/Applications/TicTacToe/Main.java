package Applications.TicTacToe;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();// this will create players and put in queue and initialize the board with a size
        System.out.println("Winner is: "+game.startGame());
    }
}
