package Applications.StockBrokers;

public class ExchangeConnector {
    private static ExchangeConnector exchangeConnector;

    private ExchangeConnector(){

    }

    public static ExchangeConnector getInstance(){
        if(exchangeConnector == null){
            exchangeConnector = new ExchangeConnector();
        }
        return exchangeConnector;
    }

    public void placeOrder(Order order){
        System.out.println("Order sent to exchange");
        sendOrderToExchange(order);
    }
    private void sendOrderToExchange(Order order){
        System.out.println("sending order to Exchange "+ order.getExchangeType());
    }
}
