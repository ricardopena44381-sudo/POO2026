package model;

public class SingleRoom extends Room {
    private double singleBedRate;

    public SingleRoom(String number, int floor, boolean seaView, double baseRate, double singleBedRate) {
        super(number, floor, seaView, baseRate);
        this.singleBedRate = singleBedRate;
    }

    @Override
    public double calculateTotalRate(int guests) {
        return baseRate + singleBedRate;
    }
}
