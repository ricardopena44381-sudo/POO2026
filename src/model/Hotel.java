package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Hotel {
    private final String id;
    private final String name;
    private final String address;
    private final int totalFloors;

    private final double tbh; // Tarifa Base Habitación
    private final double tcs; // Tarifa Cama Sencilla
    private final double tmi; // Tarifa Minibar
    private final double pvm; // Porcentaje Vista al Mar
    private final double rcp; // Recargo TV Premium

    private final List<Room> rooms = new ArrayList<>();
    private final List<Guest> guests = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();
    private final List<ReservationConfirmation> confirmations = new ArrayList<>();

    public Hotel(String id, String name, String address, int totalFloors, double tbh, double tcs, double tmi, double pvm, double rcp) {
        if (totalFloors < 8) {
            throw new DomainException("El hotel debe tener al menos 8 pisos.");
        }
        this.id = id;
        this.name = name;
        this.address = address;
        this.totalFloors = totalFloors;
        this.tbh = tbh;
        this.tcs = tcs;
        this.tmi = tmi;
        this.pvm = pvm;
        this.rcp = rcp;
    }

    public void addRoom(Room room) {
        if (room.getFloor() < 1 || room.getFloor() > totalFloors) {
            throw new DomainException("El piso de la habitación no es válido.");
        }
        rooms.add(room);
    }

    public void addConfirmation(ReservationConfirmation confirmation) {
        confirmations.add(confirmation);
    }

    public Optional<ReservationConfirmation> findConfirmation(String confirmationId) {
        return confirmations.stream()
            .filter(c -> c.getId().equalsIgnoreCase(confirmationId))
            .findFirst();
    }

    public double getTbh() { return tbh; }
    public double getTcs() { return tcs; }
    public double getTmi() { return tmi; }
    public double getPvm() { return pvm; }
    public double getRcp() { return rcp; }
    public int getTotalFloors() { return totalFloors; }
}
