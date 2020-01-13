package pl.javastart.library.io;

import pl.javastart.library.model.*;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook() {
        printer.printLine("Podaj tytuł książki:");
        String title = sc.nextLine();
        printer.printLine("Podaj autora książki:");
        String author = sc.nextLine();
        printer.printLine("Podaj datę wydania książki:");
        int relaseDate = sc.nextInt();
        sc.nextLine();
        printer.printLine("Podaj liczbę stron książki:");
        int pages = sc.nextInt();
        sc.nextLine();
        printer.printLine("Podaj wydawnictwo książki:");
        String publisher = sc.nextLine();
        printer.printLine("Podaj ISBN książki:");
        String isbn = sc.nextLine();
        return new Book(title, publisher , relaseDate, author, pages, isbn);
    }

    public Magazine readAndCreateMagazine() {
        printer.printLine("Tytuł:");
        String title = sc.nextLine();
        printer.printLine("Wydawnictwo:");
        String publisher = sc.nextLine();
        printer.printLine("Język:");
        String language = sc.nextLine();
        printer.printLine("Rok wydaniea:");
        int year = sc.nextInt();
        printer.printLine("Miesiąc:");
        int month = sc.nextInt();
        printer.printLine("Dzień:");
        int day = sc.nextInt();
        return new Magazine (title, publisher, year, month, day,  language);
    }

    public int getInt() {
        try {
            return sc.nextInt();
        }finally {
            sc.nextLine();
        }
    }

    public String getString(){
        return sc.nextLine();
    }

    public void close() {
        sc.close();
    }
}
