package pr21zad4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryLister {

    /**
     * Сохраняет содержимое каталога в список и выводит первые 5 элементов
     * @param directoryPath путь к каталогу
     */
    public static void listAndPrintFirst5(String directoryPath) {
        File directory = new File(directoryPath);

        // Проверка существования каталога
        if (!directory.exists()) {
            System.out.println("Каталог не существует: " + directoryPath);
            return;
        }

        // Проверка, что это действительно каталог
        if (!directory.isDirectory()) {
            System.out.println("Указанный путь не является каталогом: " + directoryPath);
            return;
        }

        // Получаем список файлов и подкаталогов
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Каталог пуст: " + directoryPath);
            return;
        }

        // Сохраняем в список
        List<File> fileList = new ArrayList<>(Arrays.asList(files));

        // Сортируем по имени (опционально)
        fileList.sort(Comparator.comparing(File::getName));

        // Выводим первые 5 элементов
        System.out.println("Содержимое каталога " + directoryPath + ":");
        System.out.println("Всего элементов: " + fileList.size());
        System.out.println("Первые 5 элементов:");

        int count = Math.min(5, fileList.size());
        for (int i = 0; i < count; i++) {
            File file = fileList.get(i);
            String type = file.isDirectory() ? "[DIR] " : "[FILE]";
            String size = file.isFile() ? " (" + file.length() + " байт)" : "";
            System.out.printf("%d. %s %s%s%n",
                    i + 1,
                    type,
                    file.getName(),
                    size
            );
        }

        // Если есть еще элементы
        if (fileList.size() > 5) {
            System.out.println("... и еще " + (fileList.size() - 5) + " элементов");
        }
    }
}