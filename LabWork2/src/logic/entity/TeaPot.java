package logic.entity;

public class TeaPot extends Item{
    private double capacity;

    private double voltage;

    public TeaPot(double price, double capacity, double voltage) {
        this.price = price;
        this.capacity = capacity;
        this.voltage = voltage;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }
}
