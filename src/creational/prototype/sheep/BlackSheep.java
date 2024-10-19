package creational.prototype.sheep;

public class BlackSheep implements Sheep{
    private String name;
    public BlackSheep(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public BlackSheep clone(){
//        Or other cloning logic
        return new BlackSheep(this.name);
    }
}
