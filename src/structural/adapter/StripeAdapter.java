package structural.adapter;

public class StripeAdapter implements PaymentGateway {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("[Payment Successful] Transaction via Stripe for $" + amount);
        return true;
    }
}
