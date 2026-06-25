public class EmployeeTest {

	public static void main(String[] args) {

		EmployeeArray emp = new EmployeeArray(10);

		emp.add(new Employee(1, "Asvathama S K", "Developer", 60000.0));
		emp.add(new Employee(2, "Rahul Verma", "Tester", 45000.0));
		emp.add(new Employee(3, "Priya Sharma", "Manager", 80000.0));

		System.out.println("All employees:");
		emp.traverse();

		Employee found = emp.search(2);
		System.out.println("Search result: " + found);

		emp.delete(2);

		System.out.println("After deleting employee 2:");
		emp.traverse();
	}
}
