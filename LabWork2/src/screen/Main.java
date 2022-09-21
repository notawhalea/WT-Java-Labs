package screen;

/**
 * Main class
 */
public class Main {
    private static final Presenter presenter = new Presenter();

    public static void main(String[] args) {
        presenter.getItems();

        System.out.println(presenter.calcSum());
        System.out.println(presenter.countPots());
    }
}
