package by.bsuir.lab1.task15;

import java.util.ArrayList;
import java.util.Comparator;

public class ShellSort {
    public static void sort(ArrayList<Book>array, Comparator<Book> comparator) {
        int h = 1;
        while (h*3 < array.size()){
            h = h * 3 + 1;
        }


        while(h >= 1) {
            hSort(array, h,comparator);
            h = h/3;
        }
    }

    private static void hSort(ArrayList<Book> array, int h, Comparator<Book> comparator) {
        int length = array.size();
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if ( comparator.compare(array.get(j),array.get(j-1)) <0)
                    swap(array, j, j - h);
                else
                    break;
            }
        }
    }

    private static void swap(ArrayList<Book> array, int j, int i) {
        Book temp=array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }
}
