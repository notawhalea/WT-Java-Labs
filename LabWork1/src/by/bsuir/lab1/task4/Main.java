package by.bsuir.lab1.task4;

public class Main {
    public static void main(String[] args) {
        //i took N = 4;
        int[] sourceArray = new int[]{1, 2, 3, 4};
        printIndexOfPrimeNumbers(sourceArray);
    }

    public static void printIndexOfPrimeNumbers(int[] mas) {
        boolean hasPrimeNumbers = false;
        for (int i = 0; i < mas.length; i++)
            if (isPrime(mas[i])) {
                hasPrimeNumbers = true;
                System.out.println(mas[i]);
            }
        if (!hasPrimeNumbers)
            System.out.println("No prime numbers");
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n) + 1; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
}
