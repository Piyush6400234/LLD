package Applications.BookMyShow;
import Applications.BookMyShow.Enums.City;
// This will add movies based on cities, can filter out Movie list by city or by movie name
import java.util.*;
public class MovieController {
    Map<City, List<Movie>> cityVsMovie = new HashMap<>();
    List<Movie> movieList = new ArrayList<>();

    public void addMovie(City city, Movie movie) {
        if(!movieList.contains(movie)) {
            movieList.add(movie);
        }
        List<Movie> moviesByCity = cityVsMovie.getOrDefault(city, new ArrayList<>());
        if(!moviesByCity.contains(movie)){
            moviesByCity.add(movie);
        }
        cityVsMovie.put(city, moviesByCity);
        System.out.println("movies count: "+cityVsMovie.getOrDefault(city, new ArrayList<>()).size());
    }
    public List<Movie> getMovieByCity(City city){
        return cityVsMovie.get(city);
    }
    public List<Movie> getMovieByName(String movieName){
        List<Movie> filteredMovie = new ArrayList<>();
        for(Movie movie: movieList){
            if(movie.getMovieName().equalsIgnoreCase(movieName)){
                filteredMovie.add(movie);
            }
        }
        return filteredMovie;
    }
}
