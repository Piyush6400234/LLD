package creational.builder.cars;
// We are making a car that has different method and the product creation process is immutable, i.e once a step is
// performed they can't be undone.
// Director is an Optional class where client code just requests the Director to build the product, and the Director coordinates the process.
/*
--> TO avoid constructor-Bloating and getting a specific object having only some of the features. Ex - sometimes you
    want only a few values to be set in object and set only those values.
================================================= :IDEA: ==================================================
--> The Builder pattern suggests that you extract the object construction code out of its own class and move it to
    separate objects called builders.
--> The Main need to use Builder class is to avoid constructor boating or when it's an important part is that you don’t
    need to call all the steps. You can call only those steps that are necessary for producing a particular configuration
    of an object.
--> Some of the construction steps might require different implementation when you need to build various representations
    of the product. In this case, you can create several different builder classes that implement the same set of
    building steps, but in a different manner.

--> NEED OF A DIRECTOR: You can go further and extract a series of calls to the builder steps you use to construct a
    product into a separate class called director. The director class defines the order in which to execute the
    building steps, while the builder provides the implementation for those steps. Having a director class in your
    program isn’t strictly necessary. You can always call the building steps in a specific order directly from the
    client code. However, the director class might be a good place to put various construction routines, so you can
    reuse them across your program.

Get/obtain the result of the construction from the builder which performed the job.
*/


public class Main {
    public static void main(String[] args){
        CarBuilder builder = new CarBuilder();
        Director cardirector = new Director(builder);
        cardirector.createVehicle();// Eg, this will give only  a basic version of Car and building Wheel is optional
        builder.buildWheels();// you can always build a class like this.
        Car c = builder.getProduct();
        System.out.println(c.getEngine());
    }
}