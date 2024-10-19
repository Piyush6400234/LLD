package creational.prototype.sheep;

public class WhiteSheep implements Sheep{
    private String name;

    public WhiteSheep(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Sheep clone(){
//        Or other cloning logic
        return new WhiteSheep(this.name);
    }
}
