package Applications.Elevator;
/*
We have multiple floors 1, 2, 3, 4, 5..... A user comes and clicks destination floor number where he want to go,
a lift will come and take him/her to that particular floor.

Requirements: -
1). How many lift to consider - consider n
2). Lift Dispatch Algo -> Should be extensible - can be odd/even or fixed floor or Minimum seek time
            Dispatch algo should be such that we can be able to change it in the future.

Objects:
1). Building
2). Floor
3). External Button
                            |---> Display
                            |---> Current Floor
4). Elevator Car--->has-----|---> Direction --> Enum -> up, down
                            |---> status (of elevator) --> Enum --> Moving, Idle
                            |---> Internal Button(person goes and click internal Button)
5). Display
6). Internal Button
7). Doors

Elevator Car is a dumb object, it can't do anything on it's on, so it'll have only one method i.e Move(dest_floor, direction)
And to control this Elevator Car we will need an elevator controller.
For each elevator we need a specific Elevator controller.

Elevator Controller: Will get multiple request at a time, in the form of - acceptNewReq(int dest, Direction dir)
    And to store those requests we need some storing capacity.
    But the request will come after pressing button(internal/external), so we'll dispatch the request from
    button to respective (internal/external) button dispatcher
    and button dispatcher will keep all the elevator controllers within it. and will forward the request to respective
    elevator controller based on the floor ID of internal/external button.
For internal button it's a simple command to go to destination, and so it will directly forward request to Elevator controller.
But for external button, there has to be some strategy to identify which elevator is most optimised to fulfill the request. There we'll use strategy pattern.

Each floor object has an external button, and each external button has a external Button dispatcher, and each dispatcher has
a collection of Elevator controller.
Each Building object has a list of floors
When a request is dispatched to an elevator controller (by external and internal button dispatcher) it can overwhelm it.
The controller will have an algorithm to decide how to manage the Elevator. Or which request to serve first. There we'll
use Look Algorithm.

So TWO Places we need to use Algorithms
1). At External Button Dispatcher to find the most optimized lift that will fulfill the request.
2). At Elevator Controller that will use which request is to be served first(among all the requests from external/internal dispatcher).
*/
public class Main {
    public static void main(String[] args) {

    }
}
