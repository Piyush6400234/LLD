package Behavioral.Iterator.Library;
// Aggregate Interface
public interface IterableCollection<T> {
    Iterator<T> createIterator();
}