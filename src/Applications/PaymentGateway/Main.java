package Applications.PaymentGateway;
/*
Requirements:-- Considering only peer-to-peer operations

    |-------> User can be ADDED/UPDATED/DELETED.
    |
    |-------> Instrument(Bank acc1, Bank acc2, Credit crd e.t.c) can be ADDED/UPDATED/DELETED.
    |
    |
    |-------> Make Payment from U1 to U2.
APP-|     |--> Search User, to whom amount needs to be transferred.
    |     |--> Select Amount and Funding Instrument.
    |     |--> Pass information to processor.
    |
    |------> Notification for operations like Add/Remove User, Debit Payment, Credit payment e.t.c
    |
    |------> Users able to see transaction history.


MAIN entity involved in the above flow:-
1). User
2). Instrument
        - Bank
        - Card
3). Transaction
4). Transaction History
5). Notification
6). Processor

 */
public class Main {
}
