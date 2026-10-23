package model;

public class ReservationConfirmation {
    private final String id;
    private final String reservationId;
    private final String guestName;
    private final String roomNumber;
    private final int nights;
    private final double totalCost;

    public ReservationConfirmation(String id, String reservationId, String guestName, String roomNumber, int nights, double totalCost) {
        this.id = id;
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.totalCost = totalCost;
    }

    public String getId() { return id; }
    public String getReservationId() { return reservationId; }
    public String getGuestName() { return guestName; }
    public String getRoomNumber() { return roomNumber; }
    public int getNights() { return nights; }
    public double getTotalCost() { return totalCost; }
}
