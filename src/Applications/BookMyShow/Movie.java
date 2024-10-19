package Applications.BookMyShow;

public class Movie {
    int movieId;
    String movieName;
    int movieDurationInMinutes;
    public Movie(int movieId, String movieName){
        this.movieId = movieId;
        this.movieName = movieName;
    }
    public String getMovieName() {
        return movieName;
    }
    public int getMovieId() {
        return movieId;
    }

    public int getMovieDurationInMinutes() {
        return movieDurationInMinutes;
    }

    public void setMovieDurationInMinutes(int movieDurationInMinutes) {
        this.movieDurationInMinutes = movieDurationInMinutes;
    }
}