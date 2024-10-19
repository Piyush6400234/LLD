package structural.adapter.parser;
/*
Adapter is a Structural Design Pattern that allows incompatible interfaces between classes to work together without
modifying their source code.

// Usually our client uses target interface but now our client have to use an adaptee class as well, but methods should
// be same as what was there in target interface.
// We now implement the target interface and internally use an instance of adaptee class and keep the method name as
//present in original target class -----> This will be our adapter.


Three components of Adapter Pattern:
a) Target: This represents the (already existing and being used by client) interface or class that the client code
//expects to work with. It defines the operations that the client can use.
b). Adaptee: This refers to the new class or interface that needs to be adapted. It has a different interface that is
incompatible with the client’s expectations.
c) Adapter: This is the class that bridges the gap between the Target and Adaptee. It implements the Target interface and
internally uses an instance of the Adaptee to perform the desired operations.

There are two implementations of Adapter Patters
1). Class Adapter Pattern -
In a class adapter, the Adapter class extends both the Target interface and the Adaptee class. It inherits the behavior
of the Adaptee and adapts it to match the Target interface. However, this approach requires multiple inheritance, which
may not be supported in some programming languages.

2). Object Adapter Pattern -
In an object adapter, the Adapter class implements the Target/adaptee interface and contains an instance of the
Adaptee/target class respectevely.


IN this example we have an existing xml user library XmlUser, now we want to use a library JsonUser that takes json data and it's method
should be similar to what we were previously using in xml library

PS: XmlData and JsonData are two different data types only for demo purpose.

 */

public class Main {
    public static void main(String[] args) {
        XmlData xmll = new XmlData("this is my xml data");
        XmlUser xmlusr = new XmlUser();
        xmlusr.displayMenus(xmll);
        xmlToJsonAdapter xadptj = new xmlToJsonAdapter();
        xadptj.displayMenus(xmll);

    }
}
