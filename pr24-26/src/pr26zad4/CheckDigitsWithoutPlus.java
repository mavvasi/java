package pr26zad4;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckDigitsWithoutPlus {
    public static void main(String[] args) {
        String[] expressions = {
                "(1 + 8) - 9 / 4",
                "6 / 5 - 2 * 9",
                "3+5 - 2",
                "10 + 20 - 30",
                "5*6+7",
                "100 - 50",
                "25 +"
        };

        // Регулярное выражение для поиска цифр, за которыми не стоит "+"
        // (и при этом после них не пробел и +)
        String regex = "\\d(?!\\s*\\+)";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Проверка выражений на наличие цифр без '+' после них:");

        for (String expr : expressions) {
            Matcher matcher = pattern.matcher(expr);
            boolean hasDigitsWithoutPlus = false;

            // Проверяем, есть ли цифры без плюса
            while (matcher.find()) {
                // Но нужно убедиться, что эта цифра не в конце строки или перед другими операторами
                int pos = matcher.start();
                if (pos < expr.length() - 1) {
                    char nextChar = expr.charAt(pos + 1);
                    if (nextChar != '+' && (nextChar != ' ' || (pos + 2 < expr.length() && expr.charAt(pos + 2) != '+'))) {
                        hasDigitsWithoutPlus = true;
                        break;
                    }
                } else {
                    hasDigitsWithoutPlus = true;
                    break;
                }
            }

            // Более точная проверка
            String preciseRegex = "\\d+(?!\\s*\\+)(?![\\d])";
            Pattern precisePattern = Pattern.compile(preciseRegex);
            Matcher preciseMatcher = precisePattern.matcher(expr);
            boolean hasMatch = preciseMatcher.find();

            System.out.println("'" + expr + "' -> " +
                    (hasMatch ? "Есть цифры без +" : "Все цифры с + или корректно"));
        }
    }
}
