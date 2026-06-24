public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PaypalAdapter(new PaypalGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());

        paypal.processPayment(100.00);
        stripe.processPayment(250.00);
    }
}