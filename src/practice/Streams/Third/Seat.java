package practice.Streams.Third;

import java.util.Random;

public record Seat(char rowMarker, int seatNumber, boolean isReserved) {

    public Seat(char rowMarker, int seatNumber){
//        this(rowMarker, seatNumber, new Random().nextBoolean());
        this(rowMarker, seatNumber, true);
    }
}
