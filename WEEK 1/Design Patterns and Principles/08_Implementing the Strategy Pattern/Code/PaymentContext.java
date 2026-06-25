public class PaymentContext {

	PaymentStrategy strategy;

	public void setStrategy(PaymentStrategy strategy) {
		this.strategy = strategy;
	}

	public void executePayment(double amount) {
		// calls whichever strategy is set
		strategy.pay(amount);
	}
}
