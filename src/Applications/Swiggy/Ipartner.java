package Applications.Swiggy;

public abstract class Ipartner {
    private String name;
    private int rating;
    // KYC details


    public Ipartner(String name) {
        this.name = name;
        this.rating = 0;
    }
    public String getName(){
        return name;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
}
