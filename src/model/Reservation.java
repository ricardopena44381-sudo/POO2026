package model;

public enum ReservationStatus {
    PENDING, CONFIRMED, CANCELLED
}

public class Reservation {
    private String id;
    private Guest guest;
    private Room room;
    private int guestCount;
    private int nights;
    private ReservationStatus status;

    public Reservation(String id, Guest guest, Room room, int guestCount, int nights) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.guestCount = guestCount;
        this.nights = nights;
        this.status = ReservationStatus.PENDING;
    }

    public Voucher confirm() {
        this.status = ReservationStatus.CONFIRMED;
        double totalCost = calculateTotal();
        return new Voucher(
            "VOUCH-" + id,
            id,
            guest.getFullName(),
            room.getNumber(),
            nights,
            totalCost
        );
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELLED;
    }

    public double calculateTotal() {
        return room.calculateCost(nights, guestCount);
    }

    public String getId() { return id; }
    public ReservationStatus getStatus() { return status; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public int getGuestCount() { return guestCount; }
    public int getNights() { return nights; }
}
