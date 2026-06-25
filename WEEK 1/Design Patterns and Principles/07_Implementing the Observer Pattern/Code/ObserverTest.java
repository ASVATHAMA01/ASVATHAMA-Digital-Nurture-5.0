public class WebApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("WebApp: " + stock + " is now $" + price);
    }
}