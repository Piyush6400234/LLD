package Applications.LibraryManagementSystem;
import java.time.*;
import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private ReservationStatus status;
    private String bookItemBarcode, memberId;
    public BookReservation(Date date, ReservationStatus status, String barcode, String memberId) {
        this.creationDate = date;
        this.status = status;
        this.bookItemBarcode = barcode;
        this.memberId = memberId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getBookItemBarcode() {
        return bookItemBarcode;
    }
}
