package structural.Facade.HomeTheater;
/*
Facade meaning ---------> Front facing
USE CASE: when you need a limited but straightforward interface to a complex subsystem.
A facade is a class that provides a simple interface to a complex subsystem which contains lots of moving parts.
A facade might provide limited functionality in comparison to working with the subsystem directly. However, it includes
 only those features that clients really care about.

Having a facade is handy when you need to integrate your app with a sophisticated library that has dozens of features,
but you just need a tiny bit of its functionality.

============================================== :Problem Statement: =======================================
Imagine you have a complex home theater system with different components: a DVD Player, a Projector, a Sound System,
and Lights. To set up a movie night, you'd have to interact with each of these components individually. Instead, we can
use a Facade to hide these complexities and provide a simple interface to set up and play a movie.

=============================================== :COMPONENTS: =============================================
1). Facade: The Facade provides convenient access to a particular part of the subsystem’s functionality. It knows where to
    direct the client’s request and how to operate all the moving parts.
2). Complex subsystem or simply subsystem: The Complex Subsystem consists of dozens of various objects. To make them
    all do something meaningful, you have to dive deep into the subsystem’s implementation details, such as initializing
    objects in the correct order and supplying them with data in the proper format.Subsystem classes aren’t aware of the
    facade’s existence. They operate within the system and work with each other directly.
3). Client: The Client uses the facade instead of calling the subsystem objects directly.
4). (Optional) Additional Facade: An Additional Facade class can be created to prevent polluting a single facade with
    unrelated features that might make it yet another complex structure. Additional facades can be used by both clients
    and other facades.


 */
public class Main {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Lights lights =new Lights();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(dvdPlayer, lights, projector, soundSystem);
        homeTheaterFacade.watchMovie("Stree");
        homeTheaterFacade.endMovie();

    }
}
/*
===========================================   Other use Cases  ========================================
1). Banking System: When you transfer money from one bank account to another, there are many processes involved (checking
    account balance, deducting money, updating records, etc.). The facade pattern could provide a simple interface
    (transferMoney()) that hides the complexity of these operations.

2). Car Ignition System: Starting a car involves multiple subsystems like the fuel injection system, battery, engine,
    etc. A facade could provide a simple interface like startCar(), which internally coordinates these subsystems.

3). Online Shopping System: Online shopping involves subsystems for payment processing, order management, and shipping
    services. A facade could provide an easy-to-use method like placeOrder() that internally manages all these operations.

4). Hotel Management System: A hotel management system could involve multiple subsystems like room booking, payment
    processing, and customer notifications. A facade can expose a simple bookRoom() interface that interacts with these
    subsystems internally.

=======================================================================================================



 */