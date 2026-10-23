package model;

public class DoubleRoom extends Room {
    private double extraPersonFee;

    public DoubleRoom(int number, double baseRate, double extraPersonFee) {
        super(number, 2, baseRate);
        this.extraPersonFee = extraPersonFee;
    }

    @Override
    public double calculateCost(int nights, int guests) {
        double nightlyRate = getBaseRate();
        if (guests > 1) {
            nightlyRate += extraPersonFee;
        }
        return nightlyRate * nights;
    }

    public double getExtraPersonFee() { return extraPersonFee; }
}
