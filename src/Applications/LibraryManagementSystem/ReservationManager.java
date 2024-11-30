package Applications.LibraryManagementSystem;

import java.util.*;

public class ReservationManager {
    public static ReservationManager reservationManager;
    private List<BookReservation> r;
    private ReservationManager(){
        this.r = new ArrayList<>();
    }
    public static ReservationManager getInstance(){
        if(reservationManager == null){
            reservationManager = new ReservationManager();
        }
        return reservationManager;
    }

    public boolean save(BookReservation b) {
        /* used when the book is not available but u want to get notified as soon as it's available, this
            reservation will be updated to AVAILABLE when same barCode book will be returned by someone else.
            And will be removed when u will go to checkout.
        */
        r.add(b);
        System.out.println("Reservation saved.");
        return true;
    }
    public void removeReservation(BookReservation br){
        r.remove(br);
    }

    public BookReservation fetchReservationDetails(String barcode) {
        for(BookReservation b: r){
            if(b.getBookItemBarcode().equals(barcode)){
                return b;
            }
        }
        return null;
    }
}
