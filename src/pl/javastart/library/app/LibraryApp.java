package pl.javastart.library.app;

public class LibraryApp {
    final static String APP_NAME = "Biblioteka v1.1";

    //qwerty
    //123
    public static void main(String[] args) {
        System.out.println(APP_NAME);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();

    }
}
