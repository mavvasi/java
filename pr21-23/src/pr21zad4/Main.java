package pr21zad4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Укажите путь к существующему каталогу
        String testDirectory = ".";
        String homeDirectory = System.getProperty("user.home");
        String tempDirectory = System.getProperty("java.io.tmpdir");

        DirectoryLister.listAndPrintFirst5(testDirectory);
    }
}