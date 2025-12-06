package pr26zad3;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExtractPrices {
    public static void main(String[] args) {
        String text = "Цены на товары: 25.98 USD, 1000 RUB, 44 ERR, 0.004 EU, 1500.50 RUB, 99.99 USD, 0.5 EU, 1200 RUB";

        // Регулярное выражение для извлечения цен
        String regex = "\\b\\d+\\.?\\d*\\s*(USD|RUB|EU)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Извлеченные цены из текста:");
        System.out.println("Текст: " + text);
        System.out.println("\nНайденные цены:");

        while (matcher.find()) {
            System.out.println("- " + matcher.group());
        }

        // Разделение по валютам
        System.out.println("\nЦены по валютам:");

        String[] currencies = {"USD", "RUB", "EU"};
        for (String currency : currencies) {
            Pattern currPattern = Pattern.compile("\\b\\d+\\.?\\d*\\s*" + currency + "\\b");
            Matcher currMatcher = currPattern.matcher(text);

            System.out.print(currency + ": ");
            boolean found = false;
            while (currMatcher.find()) {
                if (found) System.out.print(", ");
                System.out.print(currMatcher.group());
                found = true;
            }
            if (!found) System.out.print("не найдено");
            System.out.println();
        }
    }
}