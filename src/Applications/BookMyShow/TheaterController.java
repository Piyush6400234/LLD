package Applications.BookMyShow;
import java.util.*;
import Applications.BookMyShow.Enums.*;
// It will Mainly be used to filter out Theater and corresponding List<show> for a given Movie and city
public class TheaterController {
    Map<City, List<Theater>> cityVsTheater;
    List<Theater> theaterList;

    public TheaterController(){
        cityVsTheater = new HashMap<>();
        theaterList = new ArrayList<>();
    }
    public void addTheater(City city, Theater theater){
        if(!theaterList.contains(theater)){
            theaterList.add(theater);
        }
        List<Theater> theaterByCity = cityVsTheater.getOrDefault(city, new ArrayList<>());
        if(!theaterByCity.contains(theater)){
            theaterByCity.add(theater);
        }
        cityVsTheater.put(city, theaterByCity);
    }
//    input ----> Movie, city ---> Output =Theater, List<show>
    public Map<Theater, List<Show>> getAllShows(Movie movie, City city){
        List<Theater> theaters = cityVsTheater.getOrDefault(city, new ArrayList<>());

        Map<Theater, List<Show>> res = new HashMap<>();
        for(Theater theater: theaters){
            List<Show> showList = theater.getShowList();
            List<Show> filteredShow = new ArrayList<>();
            for(Show show: showList){
                if(show.getMovie() == movie){
                    filteredShow.add(show);
                }
            }
            if(!filteredShow.isEmpty()) {
                res.put(theater, filteredShow);
            }
        }
        return res;
    }
}