package creational.abstractFactory.Furniture;
// Imaging we have different family of products (different Product Interfaces = chair, sofa and table) and among those
// family each has a different variants. Example modern, victorian, traditional
// modern sofa, modern chair, modern table
// traditional sofa, traditional chair, traditional table
// victorian sofa, victorian chair, victorian table

// You need a way to create individual furniture objects(chair, sofa, table) so that they match other objects of the same
// family (e,g.- modern).
// Customers get quite mad when they receive non-matching furniture.

// Here's what Abstract Factory Pattern says:
// The first thing the Abstract Factory pattern suggests is to explicitly declare interfaces for each distinct product
// of the product family (e.g., chair, sofa or table). Then you can make all variants of products follow those interfaces.
// For example, all chair variants can implement the Chair interface; all table variants can implement the Table interface,
// and so on.
//The next move is to declare the Abstract Factory—an interface with a list of creation methods for all products that are part
// of the product family (for example, createChair, createSofa and createTable). These methods must return abstract product
// types represented by the interfaces we extracted previously: Chair, Sofa, Table and so on.


import creational.abstractFactory.Furniture.Sofa.Sofa;

public class Main {
    public static void main(String[] args){
        ModernFactory modern = new ModernFactory();
        TraditionalFactory traditional = new TraditionalFactory();
        VictorianFactory victorian = new VictorianFactory();
        Sofa s = modern.getSofa();
        s.createSofa();
        traditional.getChair().createChair();
    }
}