package model;

public class Voucher {
    private String id;
    private String reservationId;
    private String guestName;
    private int roomNumber;
    private int nights;
    private double totalValue;

    public Voucher(String id, String reservationId, String guestName, int roomNumber, int nights, double totalValue) {
        this.id = id;
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.totalValue = totalValue;
    }

    public String getId() { return id; }
    public double getTotalValue() { return totalValue; }
    public String getReservationId() { return reservationId; }
    public String getGuestName() { return guestName; }
    public int getRoomNumber() { return roomNumber; }
    public int getNights() { return nights; }
}
