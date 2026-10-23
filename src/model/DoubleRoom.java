package model;

public class DoubleRoom extends Room {

    public DoubleRoom(String number, int floor, boolean seaView, boolean premiumTv, Hotel hotel) {
        super(number, floor, seaView, premiumTv, hotel);
    }

    @Override
    public int getMaxCapacity() {
        return 2;
    }

    @Override
    public double calculateBedRate(int guests) {
        if (guests == 1) {
            return hotel.getTcs() * 1.45; // TCD1
        }
        return hotel.getTcs() * 1.90; // TCD2
    }
}
