import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product p) {
        products.put(p.productId, p);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product p = products.get(productId);
        if (p != null) {
            p.quantity = quantity;
            p.price = price;
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public void displayAll() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}
