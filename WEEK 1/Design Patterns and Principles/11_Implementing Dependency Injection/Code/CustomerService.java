public class CustomerService {

	CustomerRepository repository;

	// repository is injected through the constructor
	CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public void printCustomer(int id) {
		String name = repository.findCustomerById(id);
		if (name == null) {
			System.out.println("No customer found with id " + id);
		} else {
			System.out.println("Customer found: " + name);
		}
	}
}
