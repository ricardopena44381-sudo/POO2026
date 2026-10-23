package model;

public class SingleRoom extends Room {

    public SingleRoom(int number, double baseRate) {
        super(number, 1, baseRate);
    }

    @Override
    public double calculateCost(int nights, int guests) {
        return getBaseRate() * nights;
    }
}
