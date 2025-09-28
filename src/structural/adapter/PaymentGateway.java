package structural.adapter;

public interface PaymentGateway {
    boolean processPayment(double amount);
}
