package Applications.ATM;
/*
Requirements:
1). Person should be able to insert Card only and should have 2 options
       -> CashWithdrawal
       -> DisplayBalance.
2). Should be able to enter his PIN and proceed.
3). ATM should have 1k, 500, 100 Notes currency
4). ATM should have proper Exit functionality

states:
-------------------------------------------------------------
state: Idle state        |
                         | Insert card
-----------------------------------------------------------
Has Card State           | authenticate Pin
                         | Exit
--------------------------------------------------------------
SelectOperations State   | show Operations
                         | select Operation
                         | Exit
--------------------------------------------------------------
CashWithdrawal State     | cash withdrawal ----> Use of Chain Of Responsibility as well(if required).
                         | Exit
--------------------------------------------------------------
CheckBalance State       | Display Balance
                         | Exit
--------------------------------------------------------------

CLASSES:
BankAccount - Contains details like Account number, Bank Home branch Name, IFSC code, Name, Age etc.
            Contains function to directly deduct Money from Bank Account.
Card - Contains attributes like - BankAccount Object, Card details(CVV, CardNum, CardHolder's Name, ExpDate, PIN and other hidden details if any),
       Contains Functions like - deductBalance method which will use BankAccount's withdrawal method.
       CashWithdrawalState will use this method directly.
User - Card, BankAccount
Transaction type - Enum That will contain WITHDRAWAL or BALANCE_CHECK
ATM - This will contain CurrentState, Available ATM Cash Balance, NumOf1KNotes, NumOf500Notes, NumOf100Notes etc.
ATMRoom - Have attributes like ATM class, and User class
        - Will manage ATM initialization(use by maintenance team to deposit cash Notes)
        - Create Card class,
        - Create BankAccount Class
        - Create User class
       Client will Interact with ATMRoom Itself and ATMRoom will use CurrentState of ATM to perform different Operations.

*/
public class Main {
    public static void main(String[] args) {
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();// Can only be used by maintenance team.

//------------------------- : Following steps will be used every time a new user comes-in: -------------------
        atmRoom.createUser();// Pass important credentials here(cvv, cardNum, BankName, expDate, CardUser)
        atmRoom.getAtm().printATMState(); // can be moved to ATMROom
        atmRoom.getAtm().getCurrentState().insertCard(atmRoom.getAtm(), atmRoom.getUser().getCard());
        atmRoom.getAtm().getCurrentState().authenticatePin(atmRoom.getAtm(), atmRoom.user.getCard(),134);
        atmRoom.getAtm().getCurrentState().selectOperation(atmRoom.getAtm(), atmRoom.getUser().getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.getAtm().getCurrentState().cashWithdrawal(atmRoom.getAtm(), atmRoom.getUser().getCard(), 200);
        atmRoom.getAtm().printATMState();
    }
}
