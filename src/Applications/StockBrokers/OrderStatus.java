package Applications.StockBrokers;

public enum OrderStatus {
    OPEN,
    PARTIALLY_DONE, // if out of 100 stock selling transaction 40 are done and 60 or not.
    DONE,
    CANCELLED
}
