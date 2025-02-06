package Applications.StockBrokers;

public class Stock {
    private String name;
    private double price;
    private ExchangeType type;

    public Stock(String name, double price, ExchangeType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
    public String getName(){
        return name;
    }
}
