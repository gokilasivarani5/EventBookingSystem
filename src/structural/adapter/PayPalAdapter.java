package structural.adapter;

public class PayPalAdapter implements PaymentGateway {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("[Payment Successful] Transaction via PayPal for $" + amount);
        return true;
    }
}
