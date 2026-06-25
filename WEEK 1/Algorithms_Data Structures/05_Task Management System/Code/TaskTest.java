public class TaskTest {

	public static void main(String[] args) {

		TaskList list = new TaskList();

		list.add(new Task(1, "Design database schema", "Pending"));
		list.add(new Task(2, "Build login page", "In Progress"));
		list.add(new Task(3, "Write unit tests", "Pending"));

		System.out.println("All tasks:");
		list.traverse();

		Task found = list.search(2);
		System.out.println("Search result: " + found);

		list.delete(2);

		System.out.println("After deleting task 2:");
		list.traverse();
	}
}
