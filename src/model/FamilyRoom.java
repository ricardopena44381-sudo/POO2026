package model;

public class FamilyRoom extends Room {

    public FamilyRoom(String number, int floor, boolean seaView, boolean premiumTv, Hotel hotel) {
        super(number, floor, seaView, premiumTv, hotel);
    }

    @Override
    public int getMaxCapacity() {
        return 8; // Capacidad máxima según configuración de camas
    }

    @Override
    public double calculateBedRate(int guests) {
        // Tarifa mínima de camas (2 camas dobles ocupadas por 2 personas + 2 camas sencillas)
        double minBedRate = (2 * hotel.getTcs() * 1.90) + (2 * hotel.getTcs());

        if (guests <= 6) {
            return minBedRate;
        }

        // Si excede los 6 huéspedes, se suma el 70% de la tarifa de cama sencilla por cada extra
        int extraGuests = guests - 6;
        double additionalGuestRate = hotel.getTcs() * 0.70;
        return minBedRate + (extraGuests * additionalGuestRate);
    }
}
