package Behavioral.strategy.Payments;
/*
STRATEGY PATTERN - The Strategy Pattern is a behavioral design pattern that allows you to define a family of algorithms or behaviors and
encapsulate them into separate classes, making them interchangeable. The pattern enables the selection of an algorithm
at runtime without altering the objects that use it.
================================================= :COMPONENTS: ====================================================
STRATEGY INTERFACE: The Strategy interface is common to all concrete strategies. It declares a method the context uses
to execute a strategy.
CONCRETE STRATEGY: Concrete Strategies implement different variations of an algorithm the context uses.
CONTEXT: The Context maintains a reference to one of the concrete strategies and communicates with this object only via
the strategy interface.
CLIENT: The Client creates a specific strategy object and passes it to the context. The context exposes a setter which
lets clients replace the strategy associated with the context at runtime.

================================================= :CORE WORKING PRINCIPLE: ========================================
1). The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and
    extract all of these algorithms into separate classes called strategies.

2). The original class, called context, must have a field for storing a reference to one of the strategies. The context
    delegates the work to a linked strategy object instead of executing it on its own.

3). The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the
    desired strategy to the context. In fact, the context doesn’t know much about strategies. It works with all strategies
    through the same generic interface, which only exposes a single method for triggering the algorithm encapsulated
    within the selected strategy.

4). This way the context becomes independent of concrete strategies, so you can add new algorithms or modify existing
    ones without changing the code of the context or other strategies.

================================================= :USE CASE: =====================================================
Imagine you have a payment processing system that needs to support multiple payment methods like credit cards, PayPal,
and cryptocurrency. Each payment method has different logic, but you don’t want to hardcode the logic into a single
class. Using the Strategy Pattern, you can encapsulate each payment method's logic into a separate class and switch
between them at runtime.

creditCard uses - uses cardnumber, cardHolder's Name
PayaliStrategy - Used email
BitCoinStrategy - uses walletAddress
 */
public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        PaymentInterface creditCard = new CreditCardStrategy("1234-5678-9876-5432", "Piyush Doe");
        context.setPaymentStrategy(creditCard);
        context.makePayment(1000);

        PaymentInterface bitcoins = new BitCoinStrategy("1BitcoinWalletAddressXYZ");
        context.setPaymentStrategy(bitcoins);
        context.makePayment(5200);

        PaymentInterface payPal = new PayPalStrategy("piyush@gmail.com");
        context.setPaymentStrategy(payPal);
        context.makePayment(420);

    }
}

/*
============================================= : Why Use the Strategy Pattern?: ====================================
1). Flexibility: The Strategy Pattern allows you to change the behavior of a class at runtime. In the example above, the
    payment method can be changed without modifying the core logic in PaymentContext.

2). Avoiding Conditional Logic: Without the Strategy Pattern, you might end up writing multiple conditional statements
    (if-else or switch) to handle different payment methods. This can lead to complex and hard-to-maintain code.

3). Open/Closed Principle: New payment methods can be added easily by implementing the PaymentStrategy interface,
    without changing the existing code.

4). Separation of Concerns: Each payment strategy (algorithm) is encapsulated in its own class, promoting better
    organization and readability.

============================================ :APPLICABILITY: =====================================================
CASE: Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to
    switch from one algorithm to another during runtime.

SOLUTION: The Strategy pattern lets you indirectly alter the object’s behavior at runtime by associating it with
    different sub-objects which can perform specific sub-tasks in different ways.

CASE: Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.

SOLUTION: The Strategy pattern lets you extract the varying behavior into a separate class hierarchy and combine the
    original classes into one, thereby reducing duplicate code.

CASE: Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may
    not be as important in the context of that logic.

SOLUTION: The Strategy pattern lets you isolate the code, internal data, and dependencies of various algorithms from
    the rest of the code. Various clients get a simple interface to execute the algorithms and switch them at runtime.

CASE: Use the pattern when your class has a massive conditional statement that switches between different variants of
    the same algorithm.

SOLUTION: The Strategy pattern lets you do away with such a conditional by extracting all algorithms into separate
    classes, all of which implement the same interface. The original object delegates execution to one of these objects,
    instead of implementing all variants of the algorithm.
*/