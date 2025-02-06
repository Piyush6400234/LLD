package Applications.StockBrokers;
/*               ____________
                 | stock    |
customers  ----> | brokers  |  ----------->  NSE/BSE(stock exchange)
                 |          |
                 ____________

If customer wants to buy or sell something he can deal with stock brokers(Zerodha or upstocks)
The stock brokers in turn will deal with stock exchange to process those orders.


How does stock brokers look like:
    watchlist - There are watchlist where customers can add their favourite stock to monitor them.
    funds - Here the customer will add money/fund to buy/sell stocks
    Portfolio - When you buy some stocks those are your holdings and we add it in our portfolio, to see all those.

Main job of stock broker - to buy and sell stocks
When u open the stock broker you will be able to see how market is doing, how are stocks performing

Two things - 1). Buy/sell
             2). Market value/ Limit - we can set our stock broker for a particular stock such that let's say
             but 100 stocks only when the stock reaches 90 rupees or Let's say sell 50 stocks when the
             stock price reaches 150 rupees e.t.c





 */
public class Main {
    public static void main(String[] args) {
        User user = new User("piyush");
        UserInfoSystem userInfoSystem = UserInfoSystem.getInstance();
        userInfoSystem.addUser(user);
        userInfoSystem.showAllUser();

        Stock stock = new Stock("HDFC", 85, ExchangeType.BSE);
        MarketData marketData = new MarketData();
        marketData.addStock(stock);

        Order order = new Order(TransactionType.BUY, OrderType.MARKET, ExchangeType.BSE, 85.0, 10, stock);
        OrderManager orderManager = new OrderManager();
        orderManager.placeOrder(user, order);



    }
}
