package pl.javastart.library.io;

import pl.javastart.library.model.*;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);


    public Book readAndCreateBook() {
        System.out.println("Podaj tytuł książki:");
        String title = sc.nextLine();
        System.out.println("Podaj autora książki:");
        String author = sc.nextLine();
        System.out.println("Podaj datę wydania książki:");
        int relaseDate = sc.nextInt();
        sc.nextLine();
        System.out.println("Podaj liczbę stron książki:");
        int pages = sc.nextInt();
        sc.nextLine();
        System.out.println("Podaj wydawnictwo książki:");
        String publisher = sc.nextLine();
        System.out.println("Podaj ISBN książki:");
        String isbn = sc.nextLine();
        return new Book(title, author, relaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Tytuł:");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo:");
        String publisher = sc.nextLine();
        System.out.println("Język:");
        String language = sc.nextLine();
        System.out.println("Rok wydaniea:");
        int year = sc.nextInt();
        System.out.println("Miesiąc:");
        int month = sc.nextInt();
        System.out.println("Dzień:");
        int day = sc.nextInt();
        return new Magazine (title, publisher, language, year, month, day);
    }

    public int getInt() {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }


    public void close() {
        sc.close();
    }
}
