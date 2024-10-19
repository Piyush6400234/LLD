package Applications.snakeAndLadder;

public class Jumper {
    private int startPoint;
    private int endPoint;
    public Jumper(int start, int end){
        this.endPoint = end;
        this.startPoint = start;
    }
    public int getStartPoint(){
        return this.startPoint;
    }
    public int getEndPoint(){
        return this.endPoint;
    }
}