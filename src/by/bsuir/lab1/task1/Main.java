package by.bsuir.lab1.task1;

public class Main {
    public static void main(String[] args) {
        System.out.println(calculate(14, 22));
    }

    public static double calculate(double x, double y){
        double numerator=1+Math.sin(x+y)*Math.sin(x+y);
        return numerator/(2+Math.abs(x-2*x/(1+x*x*y*y)))+x;
    }
}
