package structural.composite.Files;
/*
The Composite Pattern is a structural design pattern that allows you to compose objects into tree-like structures to
represent part-whole hierarchies. It treats individual objects and compositions of objects uniformly, meaning both
simple and complex objects can be handled through the same interface. This makes it easier to work with tree structures,
like a file system or a company hierarchy.

Using the Composite pattern makes sense only when the core model of your app can be represented as a tree.
********************
IMPORTANT :
1). Both individual objects(files) and groups of objects(folders) need to be treated uniformly.
2). Especially useful when dealing with tree structures like file systems, where folders can contain both files and
    other folders, and you want a uniform way of interacting with them
********************

Key Components:
1. Component: This is an interface or abstract class that defines the common operations for both simple and composite objects.

2. Leaf: Represents the individual objects (i.e., the simplest or lowest-level objects) that do not have any children.
         It implements the Component interface.

3. Composite: This is a container that can hold other Component objects (both Leaf and Composite objects).
            It implements the Component interface and allows operations to be applied to its child components.
 */
public class Main {
    public static void main(String[] args) {
        FileSystem file1 = new File("text1.txt");
        FileSystem file2 = new File("text2.txt");
        FileSystem file3 = new File("text3.txt");
        FileSystem file4 = new File("text4.txt");

        Folder folder1 = new Folder("folder1");
        Folder folder2 = new Folder("folder2");
        folder2.addFile(file2);
        folder1.addFile(file1);
        folder1.addFile(file4);
        folder1.addFile(folder2);
        folder1.ShowDetails();

//        file1.ShowDetails();
    }
}

/*
=========================== PROBLEM ========================
imagine that you have two types of objects: Products and Boxes. A Box can contain several Products as well as a number
of smaller Boxes. These little Boxes can also hold some Products or even smaller Boxes, and so on.

Say you decide to create an ordering system that uses these classes. Orders could contain simple products without any
wrapping, as well as boxes stuffed with products...and other boxes. How would you determine the total price of such
an order?

=========================== SOLUTION ========================
The Composite pattern suggests that you work with Products and Boxes through a common interface which declares a
method for calculating the total price.
The greatest benefit of this approach is that you don’t need to care about the concrete classes of objects that
compose the tree. You don’t need to know whether an object is a simple product or a sophisticated box. You can treat
them all the same via the common interface. When you call a method, the objects themselves pass the request
down the tree.




 */