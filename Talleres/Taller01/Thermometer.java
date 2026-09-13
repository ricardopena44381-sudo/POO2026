public class Thermometer {
    private double temperature;

    public Thermometer(double initialTemperature) {
        if (initialTemperature >= -50 && initialTemperature <= 100) {
            this.temperature = initialTemperature;
        } else {
            this.temperature = 0; // Valor por defecto si es inválido
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean setTemperature(double newTemperature) {
        if (newTemperature >= -50 && newTemperature <= 100) {
            this.temperature = newTemperature;
            return true;
        }
        return false;
    }
}