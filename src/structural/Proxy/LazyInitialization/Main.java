package structural.Proxy.LazyInitialization;
/*
Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy
controls access to the original object, allowing you to perform something either before or after the request gets
through to the original object.

A proxy class represents the actual object (referred to as the "real subject") and handles the interaction with the
client. The client interacts with the proxy as though it were interacting with the real object.

===================================== Why Use Proxy Pattern? (Use Case) ===================================
1). Controlled Access: To restrict access to certain sensitive parts of your system.
2). Expensive Object Creation: To defer or cache the creation of objects that are resource-intensive.
3). Security: To control access permissions and protect sensitive data.
4). Logging and Monitoring: To intercept method calls for logging, performance monitoring, or other extra operations.
5). Lazy Initialization: To delay resource-heavy object creation until absolutely necessary.

Note: Proxy Pattern has only one Interface like in decorator pattern
===================================== Components of Proxy Pattern =========================================
1). Subject Interface: Defines the interface that both the Real Object and Proxy implement.
2). RealSubject (Real Object): The actual object that performs the real operation.
3). Proxy: The class that controls access to the RealSubject. It can add functionality like logging, caching, or security checks.
4). Client: The client interacts with the proxy instead of the real object, and it does not know whether it's working
            with a proxy or the real object. (Nowhere in client we will use RealSubject)

Proxy class contains an instance of RealSubject(Injected or created)

=================================================== Use Case ===============================================
Imagine a scenario where loading large images takes time. Instead of loading the image right when you create the
object, you only load the image when the user actually needs to view it.
Example of Lazy-loading.

 */
public class Main {
    // We'll never instantiate RealImage, only use proxy class here.
    public static void main(String[] args) {
        Image image1 = new ImageProxy("High res img1");
        Image image2 = new ImageProxy("High res img2");

        image1.display();
        image1.display();

        image2.display();
    }
}


/*
================================================= Real-World Application: =======================================
1). Database Connections: Creating database connections can be expensive. Proxies can manage and control when to
    create or reuse a database connection, avoiding unnecessary overhead.
2). Security: A proxy can check whether a user has the necessary permissions to access certain data or perform
    certain operations.
3). Remote Method Invocation (RMI): In distributed systems, a proxy can be used to represent an object on a remote
    server. The proxy handles communication between the local machine and the remote server.
 */