package by.bsuir.lab1.task6;

public class Main {
    public static void main(String[] args) {
        printMatrix(new double[]{1,2,3,4,5,6,7,8,9});
    }
    public static void printMatrix(double[] mas){
        for (int i = 0; i <mas.length ; i++) {
            for (int j=i;j <mas.length;j++){
                System.out.printf("%.2f ",mas[j]);
            }
            for (int k=0;k<i;k++){
                System.out.printf("%.2f ",mas[k]);
            }
            System.out.println();
        }
    }
}
