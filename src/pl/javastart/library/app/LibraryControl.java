package pl.javastart.library.app;

import pl.javastart.library.io.ConsolePrinter;
import pl.javastart.library.io.DataReader;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Library;
import pl.javastart.library.model.Magazine;
import pl.javastart.library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int ADD_MAGAZINE = 2;
    private static final int PRINT_BOOKS = 3;
    private static final int PRINT_MAGAZINES = 4;

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();

            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchFieldException e) {
                printer.printLine(e.getMessage());
            }catch(InputMismatchException e){
                printer.printLine("wprowadzona wartość nie jest liczbą");
            }
        }
        return option;
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        }catch (InputMismatchException e){
            printer.printLine("Nie udało się utworzyć magazynu, niepoprawne dane");
        }catch (ArrayIndexOutOfBoundsException e){
            printer.printLine("Osiągnięto limit pojemności magazynu");
        }
    }

    private void exit() {
        printer.printLine("Koniec programu, papa");
        dataReader.close();
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        }catch (InputMismatchException e){
            printer.printLine("Nie udało się utworzyć ksiażki, niepoprawne dane");
        }catch (ArrayIndexOutOfBoundsException e){
            printer.printLine("Osiągnięto limit pojemności magazynu");
        }
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję:");
        Option[] options = Option.values();
        for (Option option : options) {
            printer.printLine(option.toString());
        }
    }
}
