package Applications.BookMyShow;
import Applications.BookMyShow.Enums.*;

import javax.naming.directory.SearchControls;
import java.util.*;
// It will have a movie controller and a Theatre controller.
public class BookMyShow {
    private TheaterController theaterController;
    private MovieController movieController;
    public BookMyShow(){
        this.theaterController = new TheaterController();
        this.movieController = new MovieController();
    }
    public void initializeBookMyShow(){
        createMovie();
        createTheater();
    }

    public void createMovie(){
        Movie bahubali = new Movie(1, "bahubali");
        bahubali.setMovieDurationInMinutes(150);
        Movie avenger = new Movie(2, "avenger");
        avenger.setMovieDurationInMinutes(140);
        this.movieController.addMovie(City.BANGALORE, bahubali);
        this.movieController.addMovie(City.DELHI, avenger);
        this.movieController.addMovie(City.BANGALORE, avenger);
        this.movieController.addMovie(City.DELHI, bahubali);
    }

    public void createTheater(){
        Movie bahubali = movieController.getMovieByName("bahubali").getFirst();
        Movie avenger = movieController.getMovieByName("avenger").getFirst();

        Theater pvr = new Theater();
        pvr.setTheaterId(12);
        pvr.setCity(City.BANGALORE);
        pvr.setScreenList(createScreen());
        List<Show> showList = new ArrayList<>();
        Show morningShow = createShow(1, bahubali, pvr.getScreenList().getFirst(), 10);
        Show eveningShow = createShow(2, avenger, pvr.getScreenList().getFirst(), 16);
        showList.add(morningShow);
        showList.add(eveningShow);
        pvr.setShowList(showList);

        Theater inox = new Theater();
        inox.setTheaterId(14);
        inox.setCity(City.DELHI);
        inox.setScreenList(createScreen());
        List<Show> inoxShowList = new ArrayList<>();
        Show inoxMorning = createShow(5, bahubali, pvr.getScreenList().getFirst(), 9);
        Show inoxEvening = createShow(6, avenger, pvr.getScreenList().getFirst(), 17);
        inoxShowList.add(inoxMorning);
        inoxShowList.add(inoxEvening);
        inox.setShowList(inoxShowList);

        theaterController.addTheater(City.BANGALORE, pvr);
        theaterController.addTheater(City.DELHI, inox);
    }
    public Show createShow(int id, Movie movie, Screen screen, int startTime){
        Show show = new Show();
        show.setShowId(id);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(startTime);
        return show;
    }

    public List<Screen> createScreen(){
        Screen screen1 = new Screen();
        screen1.setScreenId(2);
        screen1.setSeatList(createSeat());
        List<Screen> screenList = new ArrayList<>();
        screenList.add(screen1);
        return screenList;
    }


    public List<Seat> createSeat(){
        List<Seat> seatList = new ArrayList<>();
        for(int i = 0; i<40; i++){
            Seat s = new Seat(SeatCategory.SILVER, i);
            seatList.add(s);
        }
        for(int i = 40; i<70; i++){
            Seat s = new Seat(SeatCategory.GOLD, i);
            seatList.add(s);
        }
        for(int i = 70; i<100; i++){
            Seat s = new Seat(SeatCategory.PLATINUM, i);
            seatList.add(s);
        }
        return seatList;
    }

    public void createBooking(City city, String movie){
        List<Movie> moviesLive = movieController.getMovieByCity(city);
        if(moviesLive == null){
            System.out.println("No movies found in: "+city.name());
            return;
        }
        System.out.println("size: "+moviesLive.size());

        Movie interestedMovie = null;
        for(Movie movieL: moviesLive){
            if(movieL!=null && movieL.getMovieName().equalsIgnoreCase(movie)){
                interestedMovie = movieL;
                break;
            }
        }

        Map<Theater, List<Show>> theaters = theaterController.getAllShows(interestedMovie, city);
        System.out.println("size of hashmap: "+ theaters.size());
        // the following three lines will be not needed if user selects a particular show.
        Map.Entry<Theater, List<Show>> entry = theaters.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        // Let's say user selects first show of the first theater that is present in the list
        Show interestedShow = runningShows.getFirst();

        // ideally interestedShow will be given by user, but here we are just manually retrieving it.
        // And also, seatNumber will be selected/chosen by user
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getSeatBooked();
        if(!bookedSeats.contains(seatNumber)){
            Booking booking = new Booking();
            List<Seat> bookedSeat = new ArrayList<>();
            for(Seat screenSeat: interestedShow.getScreen().getSeatList()){
                if(screenSeat.getSeatId() == seatNumber){
                    bookedSeat.add(screenSeat);
                }
            }
            booking.setBookedSeats(bookedSeat);
            booking.setBookedShow(interestedShow);
        }
        else{
            System.out.println("Booking incomplete");
            return;
        }
        System.out.println("Booking successful");

    }

}
