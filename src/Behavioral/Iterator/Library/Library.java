package Behavioral.Iterator.Library;
import java.util.*;

// Concrete Aggregate
public class Library implements IterableCollection<Book>{
    private List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }
    public void addBook(Book book){
        this.books.add(book);
    }

    @Override
    public Iterator<Book> createIterator(){
        return new BookIterator(books);
    }
//    we can return multiple iterators from library iterator collection.
//    public Iterator<Book> createdifferentIterator(){
//    return new BookIteratorAnother(book);

}
