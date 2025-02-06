package Applications.LibraryManagementSystem;
import java.util.*;
public class BookItemManager {
    private static BookItemManager bookItemManager;
    List<BookItem> bookItemList;

    private BookItemManager() {
        this.bookItemList = new ArrayList<>();
    }
    public static BookItemManager getInstance(){
        if(bookItemManager == null){
            bookItemManager = new BookItemManager();
        }
        return bookItemManager;
    }
    public void addBookItem(BookItem b){
        bookItemList.add(b);
    }
    public boolean checkout(String bookBarCode, String memberId){
        /*
        find book by bookBarCode.
        check if book is able to be lent or is it refernce-only
        check if this book can be lent
        set book status to LOANED
         */
        BookItem book= null;
        for(BookItem b: bookItemList){
            if(b.getBarcode().equals(bookBarCode)){
                book = b;
            }
        }
        if(book == null)return false;
        if(book.getStatus() != BookStatus.AVAILABLE)return false;
        if(book.isReferenceOnly()){
            System.out.println("Reference-only book cannot be checked out.");
            return false;
        }
        BookLendingManager bl=  BookLendingManager.getInstance();
        if (!bl.lendBook(bookBarCode, memberId)) return false;

        book.setStatus(BookStatus.LOANED);
//        book.setBorrowed(new Date());

        return true;
    }
    public void displayBook(String barcode){
        BookItem book= null;
        for(BookItem b: bookItemList){
            if(b.getBarcode().equals(barcode)){
                book = b;
                break;
            }
        }
        if(book == null)return;
        System.out.println("Book found");
        book.displayBook();
    }
}
