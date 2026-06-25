public class EmployeeArray {

    private Employee[] employees;
    private int count;

    public EmployeeArray(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void add(Employee e) {
        if (count == employees.length) {
            System.out.println("Array is full, cannot add more employees");
            return;
        }
        employees[count] = e;
        count++;
    }

    public Employee search(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public void delete(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                // shift everything after this index one step left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                return;
            }
        }
        System.out.println("Employee not found: " + employeeId);
    }
}
