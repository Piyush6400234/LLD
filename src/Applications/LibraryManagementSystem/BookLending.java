package Applications.LibraryManagementSystem;

import java.time.*;
import java.util.Date;

public class BookLending {
    private Date creationDate, dueDate, returnDate;
    private String bookItemBarcode, memberId;

    public BookLending(String barcode, String memberId) {
        this.bookItemBarcode = barcode;
        this.memberId = memberId;
        this.creationDate = new Date();
        this.dueDate = new Date(System.currentTimeMillis() + (Constants.MAX_LENDING_DAYS * 86400000L));
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookItemBarcode() {
        return bookItemBarcode;
    }

    public String getMemberId() {
        return memberId;
    }
}
