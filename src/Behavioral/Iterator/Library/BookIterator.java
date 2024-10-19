package Behavioral.Iterator.Library;
import java.util.*;
// Concrete Iterator
public class BookIterator implements Iterator<Book>{
    private List<Book> books;
    private int pos = 0;

    public BookIterator(List<Book> books){
        this.books = books;
    }
    @Override
    public boolean hasNext(){
        return pos<books.size();
    }

    @Override
    public Book next(){
        return books.get(pos++);
    }

}