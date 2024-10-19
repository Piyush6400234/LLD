package Applications.snakeAndLadder;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard {
    private Cell[][] cells;
    private int size;
    private int numOfSnakes;
    private int numOfLadders;

    public GameBoard(int size, int numOfSnakes, int numOfLadders){
        this.size = size;
        this.numOfLadders = numOfLadders;
        this.numOfSnakes = numOfSnakes;
        cells = new Cell[size][size];
        initializeBoard();
        addSnakeAndLadders();
    }
    public int getSize(){
        return size*size-1;
    }

    public void initializeBoard(){

        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }
    private void addSnakeAndLadders(){
        int tempSnake = numOfSnakes;
        while(tempSnake > 0){
            int start = ThreadLocalRandom.current().nextInt(1, size*size-1);
            int end = ThreadLocalRandom.current().nextInt(1, size*size-1);
            if(start<=end){
                continue;
            }
            Jumper jump = new Jumper(start, end);
            Cell cell = getCellAtStart(start);
            cell.setJumper(jump);
            tempSnake--;
        }

        int tempLadder = numOfLadders;

        while (tempLadder>0){
            int start = ThreadLocalRandom.current().nextInt(1, size*size - 1);
            int end = ThreadLocalRandom.current().nextInt(1, size*size-1);
            if(start>=end){
                continue;
            }
            Jumper jump = new Jumper(start, end);
            Cell cell = getCellAtStart(start);
            cell.setJumper(jump);
            tempLadder--;
        }
    }

    public Cell getCellAtStart(int start){
        int x = start/size;
        int y = start%size;
        return cells[x][y];
    }
}