import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stock;
    private double price;

    public void setPrice(String stock, double price) {
        this.stock = stock;
        this.price = price;
        notifyObservers();
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stock, price);
        }
    }
}