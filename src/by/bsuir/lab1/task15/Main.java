package by.bsuir.lab1.task15;

import by.bsuir.lab1.task15.comparator.AuthorComparator;
import by.bsuir.lab1.task15.comparator.PriceComparator;
import by.bsuir.lab1.task15.comparator.TitleComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Book> titleComparator = new TitleComparator();
        Comparator<Book> titleAuthorComparator = new TitleComparator().thenComparing(new AuthorComparator());
        Comparator<Book> authorTitleComparator = new AuthorComparator().thenComparing(new TitleComparator());
        Comparator<Book> authorTitlePriceComparator = new AuthorComparator().thenComparing(new TitleComparator().thenComparing(new PriceComparator()));

        ArrayList<Book> bookArrayList = new ArrayList<>();

        bookArrayList.add(new

                Book("title4", "author3", 14));
        bookArrayList.add(new

                Book("title3", "author6", 9));
        bookArrayList.add(new

                Book("title2", "author0", 4));
        bookArrayList.add(new

                Book("title1", "author-1", 1));
        bookArrayList.add(new

                Book("title0", "author312", 4));

        ShellSort.sort(bookArrayList, titleAuthorComparator);
        System.out.println(bookArrayList);
    }
}
