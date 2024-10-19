package creational.prototype.employeecloneable;

/*
Prototype interface inherits from the Cloneable interface. The Cloneable interface is a marker interface in Java.
It doesn't have any methods itself, but it signifies that a class implementing this interface can be cloned.

throws CloneNotSupportedException: This throws clause indicates that the method might throw a CloneNotSupportedException
if the object cannot be cloned.

The clone() method in the Prototype interface typically performs a shallow copy.
Classes implementing Prototype need to implement their own clone() method with the logic for creating a copy.
They can potentially override the default behavior of clone() from the Object class to perform a deep copy

*/


public interface Prototype extends Cloneable{
    public Prototype clone() throws CloneNotSupportedException;
}
