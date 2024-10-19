package Behavioral.Iterator.Library;
/*
Iterator is a behavioral design pattern that provides a way to access the elements of an aggregate object
(such as a collection) sequentially without exposing its underlying representation.It lets you traverse elements of a
collection without exposing its underlying representation (list, stack, tree, etc.).
COLLECTIONS: A collection is just a container for a group of objects.
=========================================== :WHY DO WE NEED IT: =============================================
This may sound like an easy job if you have a collection based on a list. You just loop over all the elements. But how
do you sequentially traverse elements of a complex data structure, such as a tree? For example, one day you might be
just fine with depth-first traversal of a tree. Yet the next day you might require breadth-first traversal. And the
next week, you might need something else, like random access to the tree elements.
=========================================== :MAIN IDEA: ====================================================
The main idea of the Iterator pattern is to extract the traversal behavior of a collection into a separate object
called an iterator. Iterators implement various traversal algorithms. Several iterator objects can traverse the same
collection at the same time.
In addition to implementing the algorithm itself, an iterator object encapsulates all the TRAVERSAL DETAILS, such as
the CURRENT POSITION and how many elements are left till the end. Because of this, SEVERAL ITERATORS can go through
the SAME COLLECTION at the SAME TIME, independently of each other.

Usually, iterators provide one primary method for fetching elements of the collection. The client can keep running this
method until it does NOT return anything, which means that the iterator has traversed all the elements.

All iterators must implement the SAME INTERFACE. This makes the client code compatible with any collection type or any
traversal algorithm as long as there’s a proper iterator. If you need a special way to traverse a collection, you just
create a new iterator class, without having to change the collection or the client.

================================================= :COMPONENTS: =============================================
1). ITERATOR INTERFACE - The Iterator interface declares the operations required for traversing a collection: fetching
    the next element, retrieving the current position, restarting iteration, etc.
2). CONCRETE ITERATORS - Concrete Iterators implement specific algorithms for traversing a collection. The iterator
    object should track the traversal progress on its own. This allows several iterators to traverse the same collection
    independently of each other.
3). COLLECTION INTERFACE - The Collection interface declares one or multiple methods for getting iterators compatible
    with the collection. Note that the return type of the methods must be declared as the iterator interface so that the
    concrete collections can return various kinds of iterators.
4). CONCRETE COLLECTIONS - Concrete Collections return new instances of a particular concrete iterator class each time
    the client requests one. You might be wondering, where’s the rest of the collection’s code? Don’t worry, it should
    be in the same class. It’s just that these details aren’t crucial to the actual pattern, so we’re omitting them.
5). CLIENT - The Client works with both collections and iterators via their interfaces. This way the client isn’t
    coupled to concrete classes, allowing you to use various collections and iterators with the same client code.
    Typically, clients don’t create iterators on their own, but instead get them from collections. Yet, in certain
    cases, the client can create one directly; for example, when the client defines its own special iterator.

================================================ :PROBLEM IT SOLVES: =================================
Problem: If traversal logic is embedded within the collection classes(HERE BOOK), it mixes data storage with traversal logic.
Solution: The Iterator Pattern separates the traversal logic from the collection, adhering to the Single
    Responsibility Principle. Collections manage data storage; iterators manage traversal.

Problem: Clients may need access to the elements of a collection but shouldn't manipulate its internal structure.
Solution: By using iterators, the internal structure remains hidden. Clients access elements via the iterator's methods.

Problem: You may need different ways to traverse a collection (e.g., forward, backward, skip elements).
Solution: Different iterator implementations can provide various traversal methods without altering the collection

Problem: Without iterators, clients need to handle traversal logic, which can lead to code duplication and errors.
Solution: Iterators encapsulate traversal logic, making client code cleaner and less error-prone
================================================ :NOTES: =============================================
You might have different types of collections, such as List, Set, or even a Tree. Each collection can implement the
same Iterator interface but would need SEPARATE CONCRETE COLLECTION for their traversal logic.

You can use a common Iterator interface for different collections, as it only defines the basic traversal methods
like hasNext() and next(). Each collection type (e.g., List, Set, Tree) would have its own concrete iterator that
implements the same Iterator interface.

=============================================== :OBSERVATIONS: =======================================
--> If you're dealing with MULTIPLE DIFFERENT COLLECTION TYPES (e.g., List, Set, Tree), you will need to implement
    different concrete iterators because:
    * List might require sequential traversal,
    * Tree might require in-order, pre-order, or post-order traversal
    * Graph might require breadth-first or depth-first traversal
   SOLUTIONS:: * Use the same Iterator Interface: You can define a common Iterator interface with hasNext() and next()
                 methods.
               * Implement Different Concrete Iterators: Each collection type (List, Tree, etc.) will implement its
                 own iterator that understands how to traverse that specific structure.

--> If you need to support MULTIPLE TRAVERSAL STRATEGIES ON THE SAME COLLECTION (e.g., different ways of iterating
    over a tree: in-order, pre-order, etc.), you have two approaches:
   SOLUTIONS:: * MULTIPLE CONCRETE ITERATORS: Implement a different iterator for each traversal algorithm
               * Single Iterator with Custom Logic: Use a single iterator but allow it to accept different traversal
                 logic (Strategy pattern for traversal).
================================================ :USE CASE: ===========================================
Imagine a playlist in a music application that can contain different types of songs (e.g., local files, online streams).
You want to traverse through the playlist and play each song without worrying about how the songs are stored or fetched

=====-----------> WE CAN HAVE MULTIPLE CREATE_ITERATOR FUNCTION ALL RETURNING DIFFERENT ITERATORS <------==========

HERE collection is array of BOOK

*/

public class Main {
    public static void main(String[] args) {

        Library library = new Library();
        library.addBook(new Book("Book1", "piyush"));
        Iterator<Book> iterator = library.createIterator();

        while (iterator.hasNext()){
            Book book = iterator.next();
            System.out.println("Author: "+book.getAuthor()+", name: "+book.getTitle());

        }
        library.addBook(new Book("Book2", "piyush2"));
        while (iterator.hasNext()){
            Book book = iterator.next();
            System.out.println("Author: "+book.getAuthor()+", name: "+book.getTitle());

        }
    }
}

/*
============================================ :APPLICABILITY: ===============================================
CASE: Use the Iterator pattern when your collection has a complex data structure under the hood, but you want to hide
    its complexity from clients (either for convenience or security reasons).

SOLUTION: The iterator encapsulates the details of working with a complex data structure, providing the client with
    several simple methods of accessing the collection elements. While this approach is very convenient for the client,
    it also protects the collection from careless or malicious actions which the client would be able to perform if
    working with the collection directly.

CASE: Use the pattern to reduce duplication of the traversal code across your app.

SOLUTION: The code of non-trivial iteration algorithms tends to be very bulky. When placed within the business logic
    of an app, it may blur the responsibility of the original code and make it less maintainable. Moving the traversal
    code to designated iterators can help you make the code of the application more lean and clean.

CASE: Use the Iterator when you want your code to be able to traverse different data structures or when types of
    these structures are unknown beforehand.

SOLUTION: The pattern provides a couple of generic interfaces for both collections and iterators. Given that your
    code now uses these interfaces, it’ll still work if you pass it various kinds of collections and iterators that
    implement these interfaces.


*/