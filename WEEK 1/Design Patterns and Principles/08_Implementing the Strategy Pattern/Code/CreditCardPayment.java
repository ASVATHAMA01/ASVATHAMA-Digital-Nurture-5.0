public class CreditCardPayment implements PaymentStrategy {

	String cardNumber;

	CreditCardPayment(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void pay(double amount) {
		System.out.println("Paid "+amount+" using Credit Card "+cardNumber);
	}
}
