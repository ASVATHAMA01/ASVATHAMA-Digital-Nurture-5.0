public class PaypalAdapter implements PaymentProcessor {

    private PaypalGateway gateway;

    public PaypalAdapter(PaypalGateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.pay(amount);
    }
}