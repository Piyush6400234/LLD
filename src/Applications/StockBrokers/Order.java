package Applications.StockBrokers;

public class Order {
    private TransactionType transactionType;
    private OrderType orderType;
    private ExchangeType exchangeType;
    private double price;
    private int quantity;
    private Stock stock;
    //order status should be updated and once order is successful from exchange,
    //transactions should be stored (which can be viewed in tradebook)
    //ORDER_STATUS status;
    //time_t orderTime;
    //List<Transaction*> transactions;

    public Order(TransactionType transactionType, OrderType orderType, ExchangeType exchangeType, double price, int quantity, Stock stock) {
        this.transactionType = transactionType;
        this.orderType = orderType;
        this.exchangeType = exchangeType;
        this.price = price;
        this.quantity = quantity;
        this.stock = stock;
    }

    public TransactionType getTxnType(){
        return transactionType;
    }

    public ExchangeType getExchangeType() {
        return exchangeType;
    }
}