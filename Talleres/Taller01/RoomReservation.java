public class RoomReservation {
    private String guest;
    private String roomNumber;
    private int nights;
    private double pricePerNight;

    public RoomReservation(String guest, String roomNumber, int nights, double pricePerNight) {
        this.guest = guest;
        this.roomNumber = roomNumber;
        this.nights = nights > 0 ? nights : 1;
        this.pricePerNight = pricePerNight > 0 ? pricePerNight : 100.0;
    }

    public double getTotalCost() {
        return nights * pricePerNight;
    }

    public boolean updateNights(int newNights) {
        if (newNights > 0) {
            this.nights = newNights;
            return true;
        }
        return false;
    }

    public boolean updatePricePerNight(double newPrice) {
        if (newPrice > 0) {
            this.pricePerNight = newPrice;
            return true;
        }
        return false;
    }
    
    public int getNights() { return nights; }
    public double getPricePerNight() { return pricePerNight; }
}