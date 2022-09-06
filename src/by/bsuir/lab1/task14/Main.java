package by.bsuir.lab1.task14;

import java.util.Arrays;

public class Main {
    public static void main(String []args){
        Book mas[]={new Book("a",4),new Book("b",4),new Book("c",8),new Book("d",1),
                new Book("e",5),new Book("f",0),new Book("g",3)};
        sort(mas);
        System.out.println(Arrays.toString(mas));
    }
    public static void sort(Book[] array) {
        int h = 1;
        while (h*3 < array.length){
            h = h * 3 + 1;
        }

        while(h >= 1) {
            hSort(array, h);
            h = h/3;
        }
    }
    private static void hSort(Book[] array, int h) {
        int length = array.length;
        for (int i = h; i < length; i++) {
            for (int j = i; j >= h; j = j - h) {
                if (array[j].compareTo(array[j - h])<0)
                    swap(array, j, j - h);
                else
                    break;
            }
        }
    }
    private static void swap(Book[] array, int j, int i) {
        Book temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
