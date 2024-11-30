package Applications.Uber;

public class Driver {
    private String driverId;
    private String name;
    private boolean available; // can be used int driver matching strategy
    private int rating;

    public Driver(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
