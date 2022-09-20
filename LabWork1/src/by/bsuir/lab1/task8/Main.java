package by.bsuir.lab1.task8;

public class Main {
    public static void main(String[] args) {
        printIndexes(new double[]{1, 2, 3, 4, 5, 6}, new double[]{0, 4, 6, 8, 9, 10});
    }
    public static void printIndexes(double firstMassive[], double secondMassive[]) {
        for (int i = 0; i < secondMassive.length; i++)
            System.out.println(binarySearching(firstMassive, 0, firstMassive.length - 1, secondMassive[i]));
    }

    static double binarySearching(double[] arr, int leftBorder, int rightBorder, double sElem) {
        int m = -1;
        if (sElem <= arr[leftBorder])
            return leftBorder;
        if (sElem >= arr[rightBorder])
            return rightBorder;
        while (leftBorder <= rightBorder) {
            m = (leftBorder + rightBorder) / 2;
            if (sElem >= arr[m] && sElem < arr[m + 1])
                return m + 1;
            if (sElem < arr[m])
                rightBorder = m - 1;
            if (sElem > arr[m])
                leftBorder = m + 1;
        }
        return m;
    }
}
