import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {

    private Map<Integer, String> customers;

    public CustomerRepositoryImpl() {
        customers = new HashMap<>();
        customers.put(1, "Asvathama S K");
        customers.put(2, "Rahul Verma");
        customers.put(3, "Priya Sharma");
    }

    public String findCustomerById(int id) {
        return customers.get(id);
    }
}
