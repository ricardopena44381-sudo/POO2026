package model;

public class FamilyRoom extends Room {
    private int includedGuests;
    private double extraGuestFee;

    public FamilyRoom(int number, int maxCapacity, double baseRate, int includedGuests, double extraGuestFee) {
        super(number, maxCapacity, baseRate);
        this.includedGuests = includedGuests;
        this.extraGuestFee = extraGuestFee;
    }

    @Override
    public double calculateCost(int nights, int guests) {
        double nightlyRate = getBaseRate();
        if (guests > includedGuests) {
            nightlyRate += (guests - includedGuests) * extraGuestFee;
        }
        return nightlyRate * nights;
    }

    public int getIncludedGuests() { return includedGuests; }
    public double getExtraGuestFee() { return extraGuestFee; }
}
