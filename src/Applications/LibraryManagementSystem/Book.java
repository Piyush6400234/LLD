package Applications.LibraryManagementSystem;

import java.util.*;

public abstract class Book {
    protected String ISBN, title, subject, publisher, language;
    protected int numberOfPages;
    protected List<Author> authors;

    public Book(String ISBN, String title, String subject, String publisher, String language, int numberOfPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.authors = new ArrayList<>();
    }
}
