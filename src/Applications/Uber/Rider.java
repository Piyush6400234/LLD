package Applications.Uber;

public class Rider {
    private String riderId;
    private String name;
    private int rating;

    public Rider(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
