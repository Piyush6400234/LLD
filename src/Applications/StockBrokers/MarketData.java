package Applications.StockBrokers;

import java.util.ArrayList;
import java.util.List;

// StockInventory
public class MarketData {
    private List<Stock> stocks;

    public MarketData(){
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock){
        stocks.add(stock);
    }

    public Stock getStock(String name){
        for(Stock s: stocks){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }
}
