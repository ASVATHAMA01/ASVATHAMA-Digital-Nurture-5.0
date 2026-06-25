public class StrategyPatternTest {

	public static void main(String[] args) {

		PaymentContext ctx = new PaymentContext();

		ctx.setStrategy(new CreditCardPayment("1234567890123456"));
		ctx.executePayment(250.00);

		ctx.setStrategy(new PayPalPayment("user@example.com"));
		ctx.executePayment(99.99);
	}
}
