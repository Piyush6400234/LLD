package Behavioral.Command.SmartHome;
/*
------------------------------------------- :It's somewhat Challenging: ----------------------------------
Also Known as Action, Transaction
Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information
about the request, allowing for parameterization of clients with queues, requests, and operations

------------> :But, what does "turning a request into a stand-alone object" mean?
*). Normally, when you invoke a method, you're directly calling a function or performing an action immediately.
    However, sometimes you might want to:
    1). Log the action
    2). Delay or schedule the action
    3). Undo the action
    4). Reuse the action later
    5). Store the action in a queue or history
To do this, you "encapsulate" the request by representing it as an object. This object contains all the details necessary
to execute the request, such as:
    1). The action you want to perform (like calling a specific method)
    2). The receiver of the action (the object on which the action will be performed)
    3). Parameters that the action might need
For example, instead of directly calling receiver.turnOn(), you would create a TurnOnCommand object that knows how to
execute this request when needed.Also, to turnOn the receiver, only turnOn() command may not be enough, we may need a series of steps.
------------> : And what does "Parameterization of clients with queues, requests, and operations" mean?
Parameterization means allowing a client to be more flexible by allowing it to take different commands (requests) as
parameters. In this context, clients can be configured to handle different operations, commands, or sequences of commands.

The QUEUE aspect refers to the fact that commands can be stored in a queue, allowing you to:
    1). Execute them in order later
    2). Track what has been requested
    3). Undo or redo actions (if needed)
REQUESTS and OPERATIONS are just the actions encapsulated in the command objects, which are treated as parameters.
By giving a client a command (or a series of commands), you're effectively telling it what to do without hardcoding
the specific operation inside the client itself. This allows:
    1). Loose coupling: The client doesn't need to know what specific actions it will perform ahead of time.
    2). Flexibility: The client can work with any command (or set of commands), making it more adaptable.
=================================================== :WORKING: ============================================
The Command pattern suggests that Client objects should not send requests directly to receiver. Instead, you should extract
all the request details, such as the object(receiver) being called, the name of the method and the list of arguments into a
separate command class with a single method that triggers this request(to receiver).

Command objects serve as links between various client operations and business logic objects. From now on, the client object
does not need to know what receiver/business-logic-object will receive the request and how it’ll be processed. The client
object just triggers the command, which handles all the details.

NOTES ABOUT COMMANDS?????
The next step is to make your commands implement the same interface. Usually it has just a single execution method that
takes no parameters. This interface lets you use various commands with the same request sender(assume different
clients-operations in a single client), without coupling it to concrete classes of commands. As a bonus, now you can
switch command objects linked to the sender, effectively changing the sender’s behavior at runtime.

NO PARAMETERS TO BE PASSED TO THE COMMAND'S EXECUTION METHOD.
command should be either pre-configured with this data, or capable of getting it on its own.

==================================================== :COMPONENTS: ======================================================
1). COMMAND INTERFACE: The Command interface usually declares just a single method for executing the command.
2). CONCRETE COMMANDS: Concrete Commands implement various kinds of requests. A concrete command isn’t supposed to
    perform the work on its own, but rather to pass the call to one of the business logic objects. However, for the
    sake of simplifying the code, these classes can be merged.
    Parameters required to execute a method on a receiving object can be declared as fields in the concrete command.
    You can make command objects immutable by only allowing the initialization of these fields via the constructor.
3). RECEIVER: The Receiver class contains some business logic. Almost any object may act as a receiver. Most commands
    only handle the details of how a request is passed to the receiver, while the receiver itself does the actual work.
4). SENDER/INVOKER: The Sender class (aka invoker) is responsible for initiating requests. This class must have a field
    for storing a reference to a command object. The sender triggers that command instead of sending the request directly to
    the receiver. Note that the sender isn’t responsible for creating the command object. Usually, it gets a pre-created
    command from the client via the constructor.
5). CLIENT: The Client creates and configures concrete command objects. The client must pass all the request
    parameters, including a receiver instance, into the command’s constructor. After that, the resulting command may be
    associated with one or multiple senders.

Use-case:
Imagine you are building a smart home system. You want to control lights, fans, and other appliances using a remote
control. Instead of tightly coupling the remote control to specific actions, you can use the Command pattern to
decouple them.
*/
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Fan fan = new Fan();
        LightOnCommand lighton = new LightOnCommand(light);
        LightOffCommand lightoff = new LightOffCommand(light);
        RemoteControl invoke = new RemoteControl();
        invoke.setCommand(lighton);
        invoke.pressButton();
        invoke.setCommand(lightoff);
        invoke.pressButton();


    }
}


/*
=================================================== :Problem It Solves: =============================================
The Command Pattern addresses several challenges:

1). Decoupling request senders and receivers: This makes it easier to maintain, modify, and extend the system.
2). Undoable actions: If you need the ability to undo and redo operations, commands are easy to store and reverse.
3). Queueing operations: You can queue operations, which is useful in multi-threaded environments or where you want to
    delay action execution.

==================================================== :APPLICABILITY: =============================================
CASE: Use the Command pattern when you want to parametrize objects with operations.
SOLUTION: The Command pattern can turn a specific method call into a stand-alone object. This change opens up a lot of
        interesting uses: you can pass commands as method arguments, store them inside other objects, switch linked
        commands at runtime, etc.

CASE: Use the Command pattern when you want to queue operations, schedule their execution, or execute them remotely.
SOLUTION: As with any other object, a command can be serialized, which means converting it to a string that can be
        easily written to a file or a database. Later, the string can be restored as the initial command object. Thus,
        you can delay and schedule command execution. But there’s even more! In the same way, you can queue, log or
        send commands over the network.

CASE: Use the Command pattern when you want to implement reversible operations.
SOLUTION: To be able to revert operations, you need to implement the history of performed operations. The command
        history is a stack that contains all executed command objects along with related backups of the application’s state.
        This method has two drawbacks. First, it isn’t that easy to save an application’s state because some of it can
        be private. This problem can be mitigated with the Memento pattern.
        Second, the state backups may consume quite a lot of RAM. Therefore, sometimes you can resort to an alternative
        implementation: instead of restoring the past state, the command performs the inverse operation. The reverse
        operation also has a price: it may turn out to be hard or even impossible to implement.
*/