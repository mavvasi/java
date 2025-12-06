package pr26zad2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CheckSpecificString {
    public static void main(String[] args) {
        String[] testStrings = {
                "abcdefghijklmnopqrstuv18340",
                "abcdefghijklmnoasdfasdpqrstuv18340",
                "abcdefghijklmnopqrstuv18341",
                "abcdefghijklmnopqrstuv18340 ",
                " abcdefghijklmnopqrstuv18340"
        };

        // Регулярное выражение для точного совпадения
        String regex = "^abcdefghijklmnopqrstuv18340$";
        Pattern pattern = Pattern.compile(regex);

        System.out.println("Проверка строк на соответствие 'abcdefghijklmnopqrstuv18340':");
        for (String str : testStrings) {
            Matcher matcher = pattern.matcher(str);
            boolean matches = matcher.matches();
            System.out.println("'" + str + "' -> " + (matches ? "Совпадает" : "Не совпадает"));
        }
    }
}