package screen;

import logic.entity.Item;
import logic.entity.Oven;
import logic.entity.Refrigerator;
import logic.entity.TeaPot;

public class Main {
    private static final Presenter presenter = new Presenter();

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Refrigerator(120.0, -10.0, 10.0, 170),
                new TeaPot(20.0, 1000.0, 5.0),
                new Oven(5.0, 100.0, 0.0, 5)
        };

        System.out.println(presenter.calcSum());
        System.out.println(presenter.countPots());
    }
}
