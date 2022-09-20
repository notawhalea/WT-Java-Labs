package by.bsuir.lab1.task3;

public class Main {
    public static void main(String[] args) {
        double h = 0.2;
        double a = -1;
        double b = 1;
        System.out.println("-------------------");
        for (double x = a; x <= b; x+=h )
            System.out.format("| %.4f | %.4f |\n", x, function(x));
        System.out.println("-------------------");
    }

    private static double function(double x){
        return Math.tan(x);
    }
}
