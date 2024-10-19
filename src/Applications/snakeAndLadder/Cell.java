package Applications.snakeAndLadder;

public class Cell {
    private Jumper jump;

    public void setJumper(Jumper jumper){
        this.jump = jumper;
    }

    public Jumper getJumper(){
        return this.jump;
    }
}
