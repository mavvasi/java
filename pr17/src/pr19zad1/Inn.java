package pr19zad1;

public class Inn {

    // Проверка формата ИНН (упрощенная версия)
    public static boolean isValidInn(String inn) {
        if (inn == null || inn.isEmpty()) {
            return false;
        }

        // Проверяем длину ИНН (10 или 12 цифр)
        if (inn.length() != 10 && inn.length() != 12) {
            return false;
        }

        // Проверяем, что все символы - цифры
        for (char c : inn.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        // Дополнительные проверки (можно добавить проверку контрольной суммы)
        return true;
    }

    // Проверка ИНН с выбросом исключения
    public static void validateInn(String inn) throws InvalidInn {
        if (!isValidInn(inn)) {
            throw new InvalidInn ("Недействительный ИНН: " + inn +
                    ". ИНН должен содержать 10 или 12 цифр.");
        }
    }
}