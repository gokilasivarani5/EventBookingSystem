package behavioral.strategy;

public class EarlyBirdPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int quantity) {
        return basePrice * quantity * 0.8; // 20% discount
    }
}
