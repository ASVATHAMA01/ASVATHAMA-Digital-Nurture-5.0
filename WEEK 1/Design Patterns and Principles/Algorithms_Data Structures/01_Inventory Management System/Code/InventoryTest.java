public class InventoryTest {

	public static void main(String[] args) {

		Inventory inventory = new Inventory();

		inventory.addProduct(new Product(101, "Laptop", 10, 55000.0));
		inventory.addProduct(new Product(102, "Mouse", 50, 450.0));
		inventory.addProduct(new Product(103, "Keyboard", 30, 800.0));

		System.out.println("Initial Inventory:");
		inventory.displayAll();

		// update stock after a new shipment
		inventory.updateProduct(102, 75, 420.0);

		inventory.deleteProduct(103);

		System.out.println("Updated Inventory:");
		inventory.displayAll();
	}
}
