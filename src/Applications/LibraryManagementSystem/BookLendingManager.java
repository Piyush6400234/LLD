package Applications.LibraryManagementSystem;
import java.util.*;
public class BookLendingManager {
    private static  BookLendingManager bookLendManager;
    List<BookLending> bookLendings;

    private BookLendingManager() {
       this.bookLendings = new ArrayList<>();
    }
    public static BookLendingManager getInstance(){
        if(bookLendManager == null){
            bookLendManager = new BookLendingManager();
        }
        return bookLendManager;
    }

    public boolean lendBook(String barcode, String memberId) {
        if(fetchLendingDetails(barcode) != null && fetchLendingDetails(barcode).getReturnDate()!=null)
            return false;
        BookLending lending = new BookLending(barcode, memberId);
        System.out.println("Book lent to a member.");
        bookLendings.add(lending);
        return true;
    }
    public BookLending fetchLendingDetails(String barcode) {
        for(BookLending bk: bookLendings){
            if(bk.getBookItemBarcode().equals(barcode)){
                return bk;
            }
        }

        return null;
    }
}
