package Applications.Uber;

public class TripMetaData {
    private Location srcLoc;
    private Location dstLoc;
    private int driverRating;
    private int riderRating;

    public TripMetaData(Location srcLoc, Location dstLoc, int riderRating) {
        this.srcLoc = srcLoc;
        this.dstLoc = dstLoc;
        this.riderRating = riderRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }
}
