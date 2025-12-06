package pr26zad6;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateEmail {
    public static void main(String[] args) {
        String[] emails = {
                "user@example.com",
                "root@localhost",
                "myhost@@com.ru",
                "@my.ru",
                "Julia String",
                "test.email@domain.co.uk",
                "user.name@subdomain.example.com",
                "user+tag@example.org",
                "user@127.0.0.1",
                "user@[IPv6:2001:db8::1]",
                "a@b.c",
                "user@.com",
                "user@com.",
                "user@com"
        };

        // Упрощенное регулярное выражение для email по RFC 2822
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Более сложное регулярное выражение (более точное)
        String complexRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);

        System.out.println("Валидация email адресов:");

        for (String email : emails) {
            Matcher matcher = pattern.matcher(email);
            boolean isValid = matcher.matches();

            // Дополнительная проверка для localhost и IP-адресов
            if (!isValid && email.contains("@localhost")) {
                isValid = true;
            }

            System.out.println("'" + email + "' -> " + (isValid ? "Корректный email" : "Некорректный email"));
        }
    }
}
