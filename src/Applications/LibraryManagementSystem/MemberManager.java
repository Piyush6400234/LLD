package Applications.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberManager{
    private static MemberManager mm;
    List<Member> members;

    private MemberManager() {
        this.members = new ArrayList<>();
    }
    public static MemberManager getInstance(){
        if(mm == null){
            mm = new MemberManager();
        }
        return mm;
    }
    public void displayAllUsers(){
        for(Member m: members){
            System.out.println("MemberId: "+m.getMemberId());
        }

    }
    public void addMember(Member m){
        this.members.add(m);
    }
    public Member getAccountByLibraryCard(String barCode) {
        for (Member a : members) {
            if (a.getLibraryCardCode().equals(barCode)) {
                return a;
            }
        }
        return null;
    }
    public boolean checkoutBookItem(BookItem bookItem, String memberId) {
        /*
        Get Member using memberId
        check total books checkedout by member else return false;
        use BookBarcode to check if reservation already present, if present and reservtion's memberId not equals given
        memberId return false "Reserved by another member"
        if No reservation present make reservationStatus = COMPLETED

        check if BookItem.checkout(BookBar Code, memberID) == false, return false
        increaseMemberr's bookCount+=1
        return true;

        */
        Member member = null;
        for(Member m: members){
            if(m.getMemberId().equals(memberId)){
                member = m;
            }
        }
        if(member == null)return false;

        if (member.getTotalBooksCheckedout() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            System.out.println("Max books already checked out.");
            return false;
        }
        ReservationManager rm = ReservationManager.getInstance();
        BookReservation bookReservation = rm.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null && !bookReservation.getMemberId().equals(memberId)) {
            System.out.println("Reserved by another member.");
            return false;
        }
        if (bookReservation != null) {
            // memberId reserved the book when it wasn't available now it's available so, reservation is complete when checking out.
            bookReservation.setStatus(ReservationStatus.COMPLETED);
            rm.removeReservation(bookReservation);
        }
        BookItemManager bookItemManager = BookItemManager.getInstance();
//        System.out.println("here "+ bookItem.getBarcode() + " memberid "+ memberId);

        if (!bookItemManager.checkout(bookItem.getBarcode(), memberId)) return false;
        System.out.println("here");

        member.incrementTotalBooksCheckedout();
        return true;
    }
    public void returnBookItem(BookItem bookItem, String memberId) {
        /*
        Get Member using memberId,
        if Member null return
        get reservation using bookBarcode
        if no reservation present make BookStatus = AVAILABLE
        else
        if someone already made a reservation and we are returning it noe make bookstatus = RESERVED, so that the
        person who reserved it will be notified
         */
        Member member = null;
        for(Member m: members){
            if(m.getMemberId().equals(memberId)){
                member = m;
            }
        }
        if(member == null){
            System.out.println("could not find member.");
            return;
        }
//        checkForFine(bookItem.getBarcode());
        ReservationManager rm = ReservationManager.getInstance();
        BookReservation bookReservation = rm.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null) {
            bookItem.setStatus(BookStatus.RESERVED);

//            bookReservation.sendBookAvailableNotification();
        } else {
            bookItem.setStatus(BookStatus.AVAILABLE);
        }
        BookLendingManager bl = BookLendingManager.getInstance();
        BookLending bookLending = bl.fetchLendingDetails(bookItem.getBarcode());
        bookLending.setReturnDate(new Date());
    }

    public boolean renewBookItem(BookItem bookItem, String memberId) {
        /*
            Find the member
            if not found retur false;
            find reservation
            if not done by memberID
            Submit the book and make book status = RESERVED
            ELse
         */
        Member member = null;
        for(Member m: members){
            if(m.getMemberId().equals(memberId)){
                member = m;
            }
        }
        if(member == null)return false;
//        checkForFine(bookItem.getBarcode());
        ReservationManager rm = ReservationManager.getInstance();
        BookReservation reservation = rm.fetchReservationDetails(bookItem.getBarcode());
        if (reservation != null && !reservation.getMemberId().equals(memberId)) {
            System.out.println("Reserved by another member.");
            member.decrementTotalBooksCheckedout();
            bookItem.setStatus(BookStatus.RESERVED);
//            reservation.sendBookAvailableNotification();
            return false;
        } else if (reservation != null) reservation.setStatus(ReservationStatus.COMPLETED);

        BookLendingManager lendingManager = BookLendingManager.getInstance();
        lendingManager.lendBook(bookItem.getBarcode(), memberId);
        bookItem.setBorrowed(new Date());
        bookItem.setDueDate(new Date(System.currentTimeMillis() + (Constants.MAX_LENDING_DAYS * 86400000L)));
        return true;
    }



}
