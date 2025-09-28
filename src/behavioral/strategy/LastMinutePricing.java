package behavioral.strategy;

public class LastMinutePricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int quantity) {
        return basePrice * quantity * 1.2; // 20% surcharge
    }
}
