package by.bsuir.lab1.task2;


public class Main {
    public static void main(String[] args) {
        System.out.println(check(-3,4));
    }
    public static boolean check(int x, int y){
        return checkBottomOfFigure(x, y) || checkTopOfFigure(x, y);
    }

    public static boolean checkBottomOfFigure(int x, int y){
        return (x>=-6 && x<=6) && (y>=-3 && y<=0);
    }

    public static boolean checkTopOfFigure(int x, int y){
        return (x>=-4 && x<=4) && (y>=0 && y<=5);
    }
}
