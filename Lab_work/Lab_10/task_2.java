class Stock{
    private String symbol;
    private double sharePrice;

    public Stock(String sym, double price){
        symbol = sym;
        sharePrice = price;
    }

    public double getSharePrice() {
        return sharePrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toString(){
        String str = "Trading Symbol: " + symbol + "\nShare price: " + sharePrice;
        return str;
    }
}
public class task_2 {
    public static void main(String[] args) {
        Stock Alrafahcompany = new Stock("XYZ", 9.65);

        System.out.println(Alrafahcompany);
    }
}
