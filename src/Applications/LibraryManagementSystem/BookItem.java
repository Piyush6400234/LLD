package Applications.LibraryManagementSystem;
import java.time.*;
import java.util.Date;

public class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed, dueDate, dateOfPurchase, publicationDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Rack placedAt;

    public BookItem(String ISBN, String title, String subject, String publisher, String language, int numberOfPages, String barcode, boolean isReferenceOnly, Date dateOfPurchase, Date publicationDate, double price, BookFormat format, BookStatus status, Rack placedAt) {
        super(ISBN, title, subject, publisher, language, numberOfPages);
        this.barcode = barcode;
        this.isReferenceOnly = isReferenceOnly;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
        this.price = price;
        this.format = format;
        this.status = status;
        this.placedAt = placedAt;
    }

    public String getBarcode() {
        return barcode;
    }
    public void setDue(Date due){
        this.dueDate = due;
    }
    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getBorrowed() {
        return borrowed;
    }

    public boolean isReferenceOnly() {
        return isReferenceOnly;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
    public BookStatus getStatus(){
        return this.status;
    }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public void displayBook(){
        System.out.println("barcode: "+this.barcode+ " borrowed: "+this.borrowed+" dueDate: "+this.dueDate + " status: "+this.status);
    }
}
