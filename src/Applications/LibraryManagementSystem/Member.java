package Applications.LibraryManagementSystem;

import java.time.*;
import java.util.*;

public class Member extends Account {
    private LocalDate dateOfMembership;
    private int totalBooksCheckedout;

    public Member(String id, LibraryCard libraryCard, AccountStatus status, String password) {
        super(id, libraryCard, status, password);
        this.dateOfMembership = LocalDate.now();
        this.totalBooksCheckedout = 0;
    }
    public String getLibraryCardCode(){
        return libraryCard.getBarCode();
    }
    public int getTotalBooksCheckedout() { return totalBooksCheckedout; }
    public void incrementTotalBooksCheckedout() { totalBooksCheckedout++; }
    public void decrementTotalBooksCheckedout() { totalBooksCheckedout--; }


    public BookReservation reserveBookItem(BookItem bookItem) {
        BookReservation reservation = new BookReservation(new Date(), ReservationStatus.PENDING, bookItem.getBarcode(), this.id);
        return reservation;
    }

    public String getMemberId(){
        return super.getId();
    }




}