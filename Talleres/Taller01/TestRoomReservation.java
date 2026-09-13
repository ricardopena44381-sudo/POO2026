public class TestRoomReservation {
    public static void main(String[] args) {
        RoomReservation reserva = new RoomReservation("Ricardo", "101", 3, 120000.0);
        System.out.println("Noches: " + reserva.getNights() + " | Costo por noche: $" + reserva.getPricePerNight());
        System.out.println("Costo Total Inicial: $" + reserva.getTotalCost());

        reserva.updateNights(5);
        System.out.println("Actualizado a 5 noches. Nuevo costo total: $" + reserva.getTotalCost());

        boolean nocheInvalida = reserva.updateNights(-2);
        System.out.println("Intento noches negativas (-2). Aceptado: " + nocheInvalida);
        System.out.println("Costo Total Mantenido: $" + reserva.getTotalCost());
    }
}