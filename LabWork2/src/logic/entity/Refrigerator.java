package logic.entity;

public class Refrigerator extends Item{
    private double minTemperature;
    private double maxTemperature;
    private int height;

    /**
     * @param price same like in Oven.java
     * @param minTemperature
     * @param maxTemperature
     * @param height it is a height of the Item
     */
    public Refrigerator(double price, double minTemperature, double maxTemperature, int height) {
        this.price = price;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.height = height;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
