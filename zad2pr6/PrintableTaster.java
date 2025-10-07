package zad2pr6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrintableTaster {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ИНТЕРФЕЙСА PRINTABLE ===\n");

        // Создание списка объектов, реализующих Printable
        List<Printable> printables = new ArrayList<>();

        // Добавление книг
        printables.add(new Book("Война и мир", "Лев Толстой", 1869, "Роман", 1225, "978-5-389-00001-1"));
        printables.add(new Book("1984", "Джордж Оруэлл", 1949, "Антиутопия", 328, "978-5-699-00002-2"));
        printables.add(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967, "Роман", 480, "978-5-389-00003-3"));

        // Добавление журналов
        printables.add(new Magazine("National Geographic", "National Geographic Society", 256, 2023, 10));
        printables.add(new Magazine("Forbes", "Forbes Media", 185, 2023, 9));

        // Добавление газет
        printables.add(new Time("The New York Times", LocalDate.of(2023, 10, 15), 24, "Новые открытия в науке"));
        printables.add(new Time("Коммерсантъ", LocalDate.of(2023, 10, 14), 16, "Изменения в экономике"));

        // Демонстрация 1: Вызов метода print() для всех объектов
        System.out.println("1. ПЕЧАТЬ ИНФОРМАЦИИ О ВСЕХ ОБЪЕКТАХ:");
        System.out.println("=" .repeat(60));
        for (Printable printable : printables) {
            printable.print();
            System.out.println();
        }

        // Демонстрация 2: Использование методов интерфейса
        System.out.println("2. ИСПОЛЬЗОВАНИЕ МЕТОДОВ ИНТЕРФЕЙСА:");
        System.out.println("=" .repeat(50));
        for (Printable printable : printables) {
            System.out.println("Название: " + printable.getTitle());
            System.out.println("Содержание: " + printable.getContent());
            System.out.println("-".repeat(40));
        }

        // Демонстрация 3: Работа с конкретными типами через интерфейс
        System.out.println("3. ФИЛЬТРАЦИЯ ПО ТИПАМ:");
        System.out.println("=" .repeat(40));
        printBooksOnly(printables);
        printMagazinesOnly(printables);

        // Демонстрация 4: Статистика
        System.out.println("4. СТАТИСТИКА:");
        System.out.println("=" .repeat(30));
        printStatistics(printables);
    }

    // Метод для печати только книг
    public static void printBooksOnly(List<Printable> printables) {
        System.out.println("КНИГИ:");
        for (Printable printable : printables) {
            if (printable instanceof Book) {
                Book book = (Book) printable;
                System.out.println("• " + book.getTitle() + " - " + book.getAuthor() + " (" + book.getYear() + ")");
            }
        }
        System.out.println();
    }

    // Метод для печати только журналов
    public static void printMagazinesOnly(List<Printable> printables) {
        System.out.println("ЖУРНАЛЫ:");
        for (Printable printable : printables) {
            if (printable instanceof Magazine) {
                Magazine magazine = (Magazine) printable;
                System.out.println("• " + magazine.getTitle() + " - Выпуск №" + magazine.getIssueNumber());
            }
        }
        System.out.println();
    }

    // Метод для вывода статистики
    public static void printStatistics(List<Printable> printables) {
        int bookCount = 0;
        int magazineCount = 0;
        int newspaperCount = 0;

        for (Printable printable : printables) {
            if (printable instanceof Book) {
                bookCount++;
            } else if (printable instanceof Magazine) {
                magazineCount++;
            } else if (printable instanceof Time) {
                newspaperCount++;
            }
        }

        System.out.println("Книги: " + bookCount);
        System.out.println("Журналы: " + magazineCount);
        System.out.println("Газеты: " + newspaperCount);
        System.out.println("Всего: " + printables.size());
    }
}
