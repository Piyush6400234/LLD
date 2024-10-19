package Behavioral.ChainOfResponsibility.ITSupportHandler;
/*
Also known as: CoR, Chain of Command
----> CHAIN OF RESPONSIBILITY is a behavioral design pattern that lets you pass requests along a chain of handlers.
    Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in
    the chain. The CoR pattern decouples the sender of a request from its receiver by giving multiple objects the
    opportunity to handle the request.
================================================== :CORE IDEAS: ======================================
--> Chain of Responsibility relies on transforming particular behaviors into stand-alone objects called handlers.
--> The pattern suggests that you link these handlers into a chain. Each linked handler has a field for storing a reference
    to the next handler in the chain. In addition to processing a request, handlers pass the request further along the
    chain. The request travels along the chain until all handlers have had a chance to process it.
--> Here’s the best part: a handler can decide NOT TO PASS the request further down the chain and EFFECTIVELY STOP
    ANY FURTHER PROCESSING.
--> However, there’s a slightly different approach (and it’s a bit more canonical) in which, upon receiving a request,
    a handler decides whether it can process it. If it can, it DOES NOT PASS the request any further. So it’s either
    ONLY ONE handler that processes the request OR NONE AT ALL. This approach is very common when dealing with events
    in stacks of elements within a graphical user interface.
--> It’s crucial that ALL HANDLER CLASSES implement the SAME INTERFACE. Each concrete handler should only care about
    the following one having the execute method. This way you can compose chains at runtime, using various handlers
    without coupling your code to their concrete classes.

============================================ :WHEN IT'S USEFUL: ================================================
Useful when multiple handlers can process a request, and you don't want to hard-code a specific handler or tightly
couple the request with a handler. But it should be decided on the fly which one will handle it.

============================================ :COMPONENTS: ======================================================
1). Handler: The Handler declares the interface, common for all concrete handlers. It usually contains
    just a single method for handling requests, but sometimes it may also have another method for setting the next
    handler on the chain.
2). Concrete Handler: Concrete Handlers contain the actual code for processing requests. Upon receiving a request, each
    handler must decide whether to process it and, additionally, whether to pass it along the chain.
    Handlers are usually self-contained and immutable, accepting all necessary data just once via the constructor.
3). Client: The client initiates the request and sends it to the handler chain.
---- :Optional:----
4). Base Handler(Optional): It is an optional class where you can put the boilerplate code that’s common to all handler classes.
    Usually, this class defines a field for storing a reference to the next handler. The clients can build a chain by
    passing a handler to the constructor or setter of the previous handler. The class may also implement the default
    handling behavior: it can pass execution to the next handler after checking for its existence.


========================================== :DRAWBACKS: ===========================================
Some requests may end up unhandled
*/
public class Main {
    public static void main(String[] args) {
        SupportLevel highLevelSupport = new HighLevelSupport();
        SupportLevel lowLevelSupport = new LowLevelSupport();
        SupportLevel midLevelSupport = new MidLevelSupport();
        lowLevelSupport.setNexSupportLevel(midLevelSupport);
        midLevelSupport.setNexSupportLevel(highLevelSupport);

        lowLevelSupport.handleRequest("unknown");

    }
}

/*
================================================ :APPLICABILITY: ================================================
CASE: Use the Chain of Responsibility pattern when your program is expected to process different kinds of requests in
    various ways, but the exact types of requests and their sequences are unknown beforehand.

SOLUTION: The pattern lets you link several handlers into one chain and, upon receiving a request, “ask” each handler
    whether it can process it. This way all handlers get a chance to process the request.

CASE: Use the pattern when it’s essential to execute several handlers in a particular order.

SOLUTION: Since you can link the handlers in the chain in any order, all requests will get through the chain exactly
    as you planned.

CASE: Use the CoR pattern when the set of handlers and their order are supposed to change at runtime.

SOLUTION: If you provide setters for a reference field inside the handler classes, you’ll be able to insert, remove or
    reorder handlers dynamically.

====================================== :Why Use the Chain of Responsibility Pattern: ================================
1). Decoupling of Sender and Receiver: The pattern decouples the sender of a request from its receivers. The client
    does not need to know which handler processes the request, only that the request is sent to the first handler
    in the chain.

2). Flexible Chain Composition: Handlers can be added, removed, or reordered without affecting other parts of the code.
    This provides flexibility in defining the chain of responsibility dynamically.

3). Responsibility Delegation: Each handler in the chain is responsible for a particular type of request. If it can’t
    handle the request, it passes it to the next handler. This simplifies the responsibility of individual components
    and makes the system more modular.

4). Avoid Large Conditionals: Without the CoR pattern, the client code would need to manage all possible scenarios
    using conditionals (if-else or switch-case). The CoR pattern distributes responsibility across objects, improving
    maintainability.



*/