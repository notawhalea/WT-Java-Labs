package logic.entity;

/**
 * represents different items and their common fields and methods
 */
public abstract class Item {
    protected double price;

    /**
     * @return price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the same
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
