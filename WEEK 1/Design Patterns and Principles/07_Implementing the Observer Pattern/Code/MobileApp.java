public class MobileApp implements Observer {
    public void update(String stock, double price) {
        System.out.println("MobileApp: " + stock + " is now $" + price);
    }
}