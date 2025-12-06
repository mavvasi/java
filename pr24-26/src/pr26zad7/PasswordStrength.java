package pr26zad7;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PasswordStrength {
    public static void main(String[] args) {
        String[] passwords = {
                "F032_Password",
                "TrySpy1",
                "smart_pass",
                "A007",
                "StrongPass123",
                "weak",
                "ONLYUPPERCASE123",
                "onlylowercase123",
                "NoDigitsHere",
                "C0mpl3x_P@ss",
                "GoodPass_2023"
        };

        System.out.println("Проверка надежности паролей:");
        System.out.println("Требования: минимум 8 символов, заглавная буква, строчная буква, цифра");
        System.out.println("Допустимые символы: буквы, цифры, подчеркивание\n");

        for (String password : passwords) {
            boolean isStrong = isStrongPassword(password);
            System.out.println("'" + password + "' -> " +
                    (isStrong ? "Надежный пароль" : "Слабый пароль"));
        }
    }

    private static boolean isStrongPassword(String password) {
        // Минимум 8 символов
        if (password.length() < 8) {
            return false;
        }

        // Только допустимые символы
        if (!password.matches("[A-Za-z0-9_]+")) {
            return false;
        }

        // Хотя бы одна заглавная буква
        if (!Pattern.compile("[A-Z]").matcher(password).find()) {
            return false;
        }

        // Хотя бы одна строчная буква
        if (!Pattern.compile("[a-z]").matcher(password).find()) {
            return false;
        }

        // Хотя бы одна цифра
        if (!Pattern.compile("[0-9]").matcher(password).find()) {
            return false;
        }

        return true;
    }
}
