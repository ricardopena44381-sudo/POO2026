package model;

public class Reservation {
    private final String id;
    private final Guest guest;
    private final Room room;
    private final int guestsCount;
    private final int nights;
    private ReservationStatus status;

    public Reservation(String id, Guest guest, Room room, int guestsCount, int nights) {
        if (room.getStatus() != RoomStatus.ENABLED) {
            throw new DomainException("La habitación está fuera de servicio o no disponible.");
        }
        if (guestsCount < 1 || guestsCount > room.getMaxCapacity()) {
            throw new DomainException("La cantidad de huéspedes excede la capacidad de la habitación.");
        }
        if (nights < 1) {
            throw new DomainException("El número de noches debe ser mayor a cero.");
        }

        this.id = id;
        this.guest = guest;
        this.room = room;
        this.guestsCount = guestsCount;
        this.nights = nights;
        this.status = ReservationStatus.PENDING;
    }

    public double calculateTotalCost() {
        return room.calculateCostPerNight(guestsCount) * nights;
    }

    public ReservationConfirmation confirm(Hotel hotel) {
        if (status != ReservationStatus.PENDING) {
            throw new DomainException("Solo se pueden confirmar reservas en estado PENDING.");
        }
        this.status = ReservationStatus.CONFIRMED;
        ReservationConfirmation confirmation = new ReservationConfirmation(
            "CONF-" + id,
            id,
            guest.getFullName(),
            room.getNumber(),
            nights,
            calculateTotalCost()
        );
        hotel.addConfirmation(confirmation);
        return confirmation;
    }

    public void cancel() {
        if (status == ReservationStatus.CANCELLED) {
            throw new DomainException("La reserva ya se encuentra cancelada.");
        }
        this.status = ReservationStatus.CANCELLED;
    }

    public String getId() { return id; }
    public ReservationStatus getStatus() { return status; }
}
