package Behavioral.template.Bevarage;
/*
================================================ :Template Pattern: =========================================
This pattern is useful when you have a COMMON PROCESS with variations in SPECIFIC STEPS, and you want to enforce the
SEQUENCE of operations but allow subclasses to provide custom implementations.
We define the skeleton of an algorithm in a superclass but let subclasses alter specific steps of the algorithm without
changing its overall structure.

============================================== :Problem It Solves: =========================================
The Template Method Pattern helps when you have an algorithm with invariant parts (parts that don't change) and variant
parts (parts that can change). By placing the invariant part in a superclass and allowing subclasses to modify the
variant part, you avoid code duplication and ensure that the algorithm's structure is followed consistently.

process1 = step1 -> step2 -> step3 -> step4
process2 = step1 -> step2 -> step3 -> step4
But, step1 in process1 is different from step1 in process2.

The Template Method pattern suggests that you break down an algorithm into a series of steps, turn these steps into
methods, and put a series of calls to these methods inside a single template method. The steps may either be abstract,
or have some default implementation. To use the algorithm, the client is supposed to provide its own subclass, implement
all abstract steps, and override some of the optional ones if needed (but not the template method itself).
============================================= :COMPONENTS: ==============================================
1). Abstract Class (Template): The Abstract Class declares methods that act as steps of an algorithm, as well as the
    actual template method which calls these methods in a specific order. The steps may either be declared abstract
    or have some default implementation.
2). Concrete Class: Concrete Classes can override all the steps(including default or abstract), but not the template
    method itself.
3). Template Method: A method in the abstract class that defines the order of execution of steps. Some steps are defined
    in the abstract class, while others are implemented by subclasses.
    IT'S NOT A CLASS OR OBJECT, Rather A METHOD


================================ :Types Of Steps as a part of an Algorithm: =============================
Two types of steps:
1). abstract steps must be implemented by every subclass
2). optional steps already have some default implementation, but still can be overridden if needed
*/
public class Main {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareBeverage();

        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
    }
}

/*
=================================== :OBSERVATIONS: ======================================
When the steps in an algorithm vary greatly between different implementations, the Template Method Pattern may not be
the best fit. The Template Pattern works well when there is a common sequence of steps, with only certain parts of the
algorithm differing between subclasses. However, if the sequence or number of steps themselves differ across
implementations, using the Template Method would result in overly complex or rigid designs, making it unsuitable.

==================================== :APPLICABILITY: ===================================
Case: Use the Template Method pattern when you want to let clients extend only particular steps of an algorithm,
    but not the whole algorithm or its structure.

Solution: The Template Method lets you turn a monolithic algorithm into a series of individual steps which can be
    easily extended by subclasses while keeping intact the structure defined in a superclass.

Case: Use the pattern when you have several classes that contain almost identical algorithms with some minor
    differences. As a result, you might need to modify all classes when the algorithm changes.

Solution: When you turn such an algorithm into a template method, you can also pull up the steps with similar
    implementations into a superclass, eliminating code duplication. Code that varies between subclasses can
    remain in subclasses.
 */