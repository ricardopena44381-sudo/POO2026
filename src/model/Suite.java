package model;

public class Suite extends Room {
    private double fixedFee;

    public Suite(int number, double baseRate, double fixedFee) {
        super(number, 2, baseRate);
        this.fixedFee = fixedFee;
    }

    @Override
    public double calculateCost(int nights, int guests) {
        return (getBaseRate() + fixedFee) * nights;
    }

    public double getFixedFee() { return fixedFee; }
}
