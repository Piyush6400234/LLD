package Applications.Swiggy;

public class RestaurantOwner extends Ipartner{

    public RestaurantOwner(String name){
        super(name);
    }
    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public void setRating(int rating) {
        super.setRating(rating);
    }
}
