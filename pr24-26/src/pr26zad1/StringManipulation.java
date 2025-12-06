package pr26zad1;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку для обработки:");
        String input = scanner.nextLine();

        System.out.println("\n1. Разбиение строки на слова (буквенные последовательности):");
        String[] words = input.split("[^\\p{L}]+");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                System.out.println("Слово " + (i + 1) + ": " + words[i]);
            }
        }

        System.out.println("\n2. Поиск чисел в строке:");
        Pattern numberPattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher numberMatcher = numberPattern.matcher(input);
        while (numberMatcher.find()) {
            System.out.println("Найдено число: " + numberMatcher.group());
        }

        System.out.println("\n3. Поиск email адресов:");
        Pattern emailPattern = Pattern.compile("[\\w.%+-]+@[\\w.-]+\\.[A-Za-z]{2,6}");
        Matcher emailMatcher = emailPattern.matcher(input);
        while (emailMatcher.find()) {
            System.out.println("Найден email: " + emailMatcher.group());
        }

        System.out.println("\n4. Удаление всех цифр из строки:");
        String withoutDigits = input.replaceAll("\\d", "");
        System.out.println("Результат: " + withoutDigits);

        System.out.println("\n5. Замена всех пробелов на подчеркивания:");
        String withUnderscores = input.replaceAll("\\s+", "_");
        System.out.println("Результат: " + withUnderscores);

        scanner.close();
    }
}