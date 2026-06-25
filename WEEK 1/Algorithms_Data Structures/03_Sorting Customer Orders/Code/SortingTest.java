public class SortingTest {

	public static void main(String[] args) {

		Order[] bubbleOrders = {
			new Order(1, "Asvathama S K", 1500.0),
			new Order(2, "Rahul Verma", 800.0),
			new Order(3, "Priya Sharma", 3200.0),
			new Order(4, "Karthik N", 450.0)
		};

		Order[] quickOrders = {
			new Order(1, "Asvathama S K", 1500.0),
			new Order(2, "Rahul Verma", 800.0),
			new Order(3, "Priya Sharma", 3200.0),
			new Order(4, "Karthik N", 450.0)
		};

		SortUtil.bubbleSort(bubbleOrders);
		System.out.println("Sorted using Bubble Sort:");
		for (Order o : bubbleOrders) {
			System.out.println(o);
		}

		SortUtil.quickSort(quickOrders, 0, quickOrders.length - 1);
		System.out.println("Sorted using Quick Sort:");
		for (Order o : quickOrders) {
			System.out.println(o);
		}
	}
}
