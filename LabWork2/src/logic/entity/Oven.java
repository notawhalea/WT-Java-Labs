package logic.entity;

public class Oven extends Item{
    private double maxHeatTemperature;
    private double minHeatTemperature;
    private int regimes;

    /**
     * @param price it is price of the item
     * @param maxHeatTemperature it his Max and min temperature of the item
     * @param minHeatTemperature
     * @param regimes it is a regimes of the item
     */
    public Oven(double price, double maxHeatTemperature, double minHeatTemperature, int regimes) {
        this.price = price;
        this.maxHeatTemperature = maxHeatTemperature;
        this.minHeatTemperature = minHeatTemperature;
        this.regimes = regimes;
    }

    public double getMaxHeatTemperature() {
        return maxHeatTemperature;
    }

    public void setMaxHeatTemperature(double maxHeatTemperature) {
        this.maxHeatTemperature = maxHeatTemperature;
    }

    public double getMinHeatTemperature() {
        return minHeatTemperature;
    }

    public void setMinHeatTemperature(double minHeatTemperature) {
        this.minHeatTemperature = minHeatTemperature;
    }

    public int getRegimes() {
        return regimes;
    }

    public void setRegimes(int regimes) {
        this.regimes = regimes;
    }
}
