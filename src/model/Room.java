package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private int number;
    private int maxCapacity;
    private double baseRate;
    private boolean isOperational = true;
    private List<Service> services = new ArrayList<>();

    public Room(int number, int maxCapacity, double baseRate) {
        this.number = number;
        this.maxCapacity = maxCapacity;
        this.baseRate = baseRate;
    }

    public abstract double calculateCost(int nights, int guests);

    public void addService(Service service) {
        services.add(service);
    }

    public boolean isAvailable() {
        return isOperational;
    }

    public int getNumber() { return number; }
    public int getMaxCapacity() { return maxCapacity; }
    public double getBaseRate() { return baseRate; }
    public boolean isOperational() { return isOperational; }
    public void setOperational(boolean operational) { isOperational = operational; }
    public List<Service> getServices() { return services; }
}
