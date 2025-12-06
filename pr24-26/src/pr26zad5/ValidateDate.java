package pr26zad5;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

    public class ValidateDate {
        public static void main(String[] args) {
            String[] dates = {
                    "29/02/2000",
                    "30/04/2003",
                    "01/01/2003",
                    "29/02/2001",
                    "30-04-2003",
                    "1/1/1899",
                    "31/12/9999",
                    "15/08/2023",
                    "32/01/2020",
                    "29/02/1900",
                    "00/01/2000"
            };

            // Регулярное выражение для проверки даты
            // Учитываем високосные годы
            String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|[2-9][0-9])[0-9]{2})$";
            Pattern pattern = Pattern.compile(regex);

            System.out.println("Проверка дат в формате dd/mm/yyyy (1900-9999):");

            for (String date : dates) {
                Matcher matcher = pattern.matcher(date);

                if (matcher.matches()) {
                    int day = Integer.parseInt(matcher.group(1));
                    int month = Integer.parseInt(matcher.group(2));
                    int year = Integer.parseInt(matcher.group(3));

                    boolean isValid = isValidDate(day, month, year);
                    System.out.println("'" + date + "' -> " + (isValid ? "Корректная дата" : "Некорректная дата"));
                } else {
                    System.out.println("'" + date + "' -> Не соответствует формату");
                }
            }
        }

        private static boolean isValidDate(int day, int month, int year) {
            // Проверка корректности дня для месяца
            if (month == 2) {
                // Февраль
                if (isLeapYear(year)) {
                    return day <= 29;
                } else {
                    return day <= 28;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                // Месяцы с 30 днями
                return day <= 30;
            } else {
                // Месяцы с 31 днем
                return day <= 31;
            }
        }

        private static boolean isLeapYear(int year) {
            return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        }
    }