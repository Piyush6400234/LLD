package Applications.StockBrokers;

//This class has access to user details
//It's responsibility is to check if user can place the order or not
//For demo purposes it returns true
//It should be checking if user has enough funds/stocks for the buy/sell order


public class OrderValidator {

    public OrderValidator(){

    }

    public boolean validateOrder(String userId, Order order){
        UserInfoSystem userInfoSystem = UserInfoSystem.getInstance();
        User user = userInfoSystem.getUser(userId);
        if(order.getTxnType() == TransactionType.BUY){
            // Also check if funds are sufficient with user
            System.out.println( "Checking if user " + user.getId() + " has enough funds to buy ");
            System.out.println(" For now, let's assume user is a good person and return true");
        }
        else {
            System.out.println("Checking if user " + userId + " has enough stocks to sell in portfolio ");
            System.out.println(" For now, let's assume user is a good person and return true");
        }
        return true;
    }
}
