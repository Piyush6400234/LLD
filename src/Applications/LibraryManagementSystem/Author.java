package Applications.LibraryManagementSystem;
import java.util.*;

public class Author {
    private int booksPublished;
    private String name;

    public Author(String name) {
        this.booksPublished = 0;
        this.name = name;
    }

    public int getBooksPublished() {
        return booksPublished;
    }

    public void setBooksPublished(int booksPublished) {
        this.booksPublished = booksPublished;
    }

    public String getName() {
        return name;
    }

    public void setName(String author) {
        this.name = author;
    }
}