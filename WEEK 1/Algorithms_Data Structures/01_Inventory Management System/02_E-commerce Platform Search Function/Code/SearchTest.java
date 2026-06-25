public class SearchTest {

	public static void main(String[] args) {

		// unsorted array, used for linear search
		Product[] unsorted = {
			new Product(103, "Keyboard", "Electronics"),
			new Product(101, "Laptop", "Electronics"),
			new Product(105, "Desk Lamp", "Home"),
			new Product(102, "Mouse", "Electronics"),
			new Product(104, "Notebook", "Stationery")
		};

		// same products sorted by productId, needed for binary search
		Product[] sorted = {
			new Product(101, "Laptop", "Electronics"),
			new Product(102, "Mouse", "Electronics"),
			new Product(103, "Keyboard", "Electronics"),
			new Product(104, "Notebook", "Stationery"),
			new Product(105, "Desk Lamp", "Home")
		};

		Product result1 = SearchUtil.linearSearch(unsorted, 104);
		System.out.println("Linear search result: " + result1);

		Product result2 = SearchUtil.binarySearch(sorted, 104);
		System.out.println("Binary search result: " + result2);

		Product result3 = SearchUtil.binarySearch(sorted, 999);
		System.out.println("Binary search result: " + result3);
	}
}
