package Applications.StockBrokers;

public class OrderExecutioner {

    public OrderExecutioner(){

    }

    public void executeOrder(Order order){
        ExchangeConnector exchangeConnector = ExchangeConnector.getInstance();
        // get boolean true/false and return back
        exchangeConnector.placeOrder(order);
    }
}
