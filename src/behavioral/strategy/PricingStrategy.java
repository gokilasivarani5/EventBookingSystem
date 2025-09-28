package behavioral.strategy;

public interface PricingStrategy {
    double calculatePrice(double basePrice, int quantity);
}
