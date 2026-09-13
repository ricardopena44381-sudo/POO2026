public class TestThermometer {
    public static void main(String[] args) {
        Thermometer termometro = new Thermometer(25.0);
        System.out.println("Temperatura inicial: " + termometro.getTemperature() + " °C");

        boolean aceptado1 = termometro.setTemperature(35.5);
        System.out.println("Intento 35.5 °C (Valido). Aceptado: " + aceptado1 + " -> Temp: " + termometro.getTemperature());

        boolean aceptado2 = termometro.setTemperature(150.0);
        System.out.println("Intento 150 °C (Fuera de rango). Aceptado: " + aceptado2 + " -> Temp: " + termometro.getTemperature());

        boolean aceptado3 = termometro.setTemperature(-60.0);
        System.out.println("Intento -60 °C (Fuera de rango). Aceptado: " + aceptado3 + " -> Temp: " + termometro.getTemperature());
    }
}