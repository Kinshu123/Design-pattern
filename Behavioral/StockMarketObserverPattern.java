
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(Stock stock);
}

class Stock {
    private String symbol;
    private double price;
    private List<Observer> investors = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void addObserver(Observer investor) {
        investors.add(investor);
    }

    public void removeObserver(Observer investor) {
        investors.remove(investor);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer investor : investors) {
            investor.update(this);
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}

class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println(name + " is notified: " + stock.getSymbol() + " is now $" + stock.getPrice());
    }
}

public class StockMarketObserverPattern {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.0);
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        appleStock.addObserver(investor1);
        appleStock.addObserver(investor2);

        appleStock.setPrice(155.0);  // Both Alice and Bob get notified
    }
}
