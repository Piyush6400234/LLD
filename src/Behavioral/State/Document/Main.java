package Behavioral.State.Document;
/*
STATE PATTERN: State is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears
as if the object changed its class.

===================================================== :IDEA: ======================================================
The main idea is that, at any given moment, there’s a finite number of states which a program can be in. Within any
unique state, the program behaves differently, and the program can be switched from one state to another instantaneously

============================================== :HOW TO IMPLEMENT: ============================================
The State pattern suggests that you create new classes(concrete-states) for all possible states of an object(DocumentContext)
and extract all state-specific behaviors into these classes(concrete-states).

Instead of implementing all behaviors on its own, the original object, called context(DocumentContext), stores a
reference to one of the state objects(states) that represents its(DocumentContext) current state, and delegates all the
state-related work to that object(states).

To transition the context(DocumentContext) into another state, replace the active state object with another object that
represents that new state. This is possible only if all state classes follow the same interface and the context itself
works with these objects through that interface.

================================================= :COMPONENTS: ==========================================
1). STATE INTERFACE: The State interface declares the state-specific methods. These methods should make sense for all
    concrete states because you don’t want some of your states to have useless methods that will never be called.
2). CONCRETE STATES: Concrete States provide their own implementations for the state-specific methods. To avoid
    duplication of similar code across multiple states, you may provide intermediate abstract classes that encapsulate
    some common behavior.
    (OPTIONAL): State objects may store a backreference to the context object. Through this reference, the
    state can fetch any required info from the context object, as well as initiate state transitions.
3). CONTEXT: Context stores a reference to one of the concrete state objects and delegates to it all state-specific
    work. The context communicates with the state object via the state interface. The context exposes a setter for
    passing it a new state object.
4). CLIENT: The client interacts with the Context object and triggers the actions that cause state transitions.
============================================= :WHY USE THIS STATE: ===========================================
1). Eliminates Conditional Logic: Instead of having multiple if-else or switch statements to handle the different
    states of the object, the state-specific behavior is delegated to individual classes. This makes the code cleaner
    and easier to maintain.

2). Easily Extensible: New states can be added by simply creating new classes that implement the State interface.
    There’s no need to modify existing code, which reduces the risk of introducing bugs.

=================================================== :USE CASE: =================================================
Imagine a document in a workflow system that can be in one of three states: Draft, Moderation, and Published. Each
state determines what actions can be performed on the document (e.g., edit, publish, or reject). This scenario can be
modeled using the State pattern.
*/
public class Main {
    public static void main(String[] args) {
        DocumentContext docContext = new DocumentContext();
        docContext.applyState();
        docContext.setCurrState(new ModerationState());
        docContext.applyState();
        State publish = new PublishedState();
        docContext.setCurrState(publish);
        docContext.cancelState();

    }
}

/*
================================================ :APPLICABILITY: ========================================
CASE: Use the State pattern when you have an object that behaves differently depending on its current state, the number
      of states is enormous, and the state-specific code changes frequently.
SOLUTION: The pattern suggests that you extract all state-specific code into a set of distinct classes. As a result,
        you can add new states or change existing ones independently of each other, reducing the maintenance cost.

CASE: Use the pattern when you have a class polluted with massive conditionals that alter how the class behaves
        according to the current values of the class’s fields.
SOLUTION: The State pattern lets you extract branches of these conditionals into methods of corresponding state
        classes. While doing so, you can also clean temporary fields and helper methods involved in state-specific
        code out of your main class.

CASE: Use State when you have a lot of duplicate code across similar states and transitions of a condition-based
        state machine.
SOLUTION: The State pattern lets you compose hierarchies of state classes and reduce duplication by extracting common
        code into abstract base classes.

============================================ :SHORTCOMINGS: ===========================================
 Applying the pattern can be overkill if a state machine has only a few states or rarely changes.
*/