package Applications.BookMyShow;

import Applications.BookMyShow.Enums.City;

/*
User comes --> enters Location(city) --> list down Movie1, Movie2, Movie3... -->
for each Movie let's say Movie1 list down all the theaters |--> Theater1 --> 1PM-4PM, 5PM-8PM, 10PM-13PM and so on.(different show)
 where that movie is being shown                           |--> THeater2 --> 10AM-1PM, 2PM-5PM, 8PM-11PM and so on.(different show)

So, if the user selects a particular movie, all the shows in the respective theaters should be shown.
For each show of a particular theater user will see seats available for booking (56, 82, 95) e.t.c
User chooses show, and proceeds for payments.


OBJECTS:-->
    1). USER
    2). MOVIE -- movieId, movieName, movieDuration Optional other details like language, genre, director, producer, dateOfRelease etc.
    3). THEATRE -- theatreId, address, city, List<Screen>, List<Show>(time e.g 1PM-4PM)
    4). SCREEN(movie hall) -- screenId, List<Seat>, Optionl (screen width, height)
    5). SHOW -- showId, Movie, screen, startTime, List<Integer>bookedSeatIds
    6). SEAT -- seatId, row, seatCategory
    7). BOOKING -- show, List<seat>, Payment
    8). PAYMENT -- paymentId, Mode e.t.c
    9). CITY(location)
   10). MOVIE CONTROLLER -- Map<City, List<Movie>>, List<Movie>(in case we have to find any movie) and CRUD operations to ADD, FIND, REMOVE Movies
   11). THEATRE CONTROLLER -- Map<City, Theatre>, List<Theatre>allTheatre
                    A city can have multiple theatres we need that info and also since Movie is strongly tied-up with City, we need that info.
In previous design patterns like Car Rental, Parking Lot, Elevator, Snake & Ladder e.t.c we took a bottom-up approach.

But, in this particular problem our product-"Movie" is at top of the hierarchy. So, we will take a top-down approach.


*/
public class Main {
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initializeBookMyShow();
        bookMyShow.createBooking(City.BANGALORE, "bahubali");
    }
}
