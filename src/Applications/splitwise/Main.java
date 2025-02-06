package Applications.splitwise;


/*
Flow:
    User can add friend f1, f2, f3 ...
    User can create groups g1(college group), g2(home group), g3(outing group)...
    User can add (multiple)friends to a particular group
    User can create Expense from inside a group or directly from app
    After creating expense, it should have split between friends(f1, f2 ...).

Requirements:
    1). User can add friend
    2). Add/Manage Group
    3). Add/Manage friend inside a group
    4). Manage expenses inside a group or without a group
    5). Should be able to split the expenses ---> Equal split or unequal split or percentage-wise split among all the friends(Ask interviewer which type they need.)
    6). Balance sheet of each user(kis se kitna lena hai, kisko kitna dena hai)

Object Identification:
    1). Splitwise (driver obj)
    2). User
    3). Group
    4). Expense
    5). Split ??
    6). Balance sheet

When any user or a friend will open the Application it should show balance sheet and breakdown w.r.t each friend.
   ------------------------------
   |       Piyush.              |
   |  Total owe/get back:  -400 |
   | piyush owe f1 - 100        |
   | piyush get back f2 - 200   |
   | piysuh owe f3 - 500        |
   |                            |
   |                            |
   |                            |
*/
public class Main {
    public static void main(String[] args) {
        Splitwise splitwise = new Splitwise();
        splitwise.demo();
    }
}
