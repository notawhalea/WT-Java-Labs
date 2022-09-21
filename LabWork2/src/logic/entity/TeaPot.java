package logic.entity;

public class TeaPot extends Item{
    private double capacity;

    private double voltage;

    /**
     * @param price same like in Oven.java
     * @param capacity its a capacity and voltage of the item
     * @param voltage
     */
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
