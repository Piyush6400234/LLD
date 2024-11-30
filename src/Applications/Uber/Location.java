package Applications.Uber;

public class Location {
    private int latitude;
    private int longitude;

    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLong(){
        return longitude;
    }
    public int getLat(){
        return latitude;
    }
}
