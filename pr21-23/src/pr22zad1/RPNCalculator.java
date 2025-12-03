package pr22zad1;

import java.util.*;
import java.util.function.BinaryOperator;

public class RPNCalculator {


    public static double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Выражение не может быть пустым");
        }

        String[] tokens = expression.trim().split("\\s+");
        Deque<Double> stack = new ArrayDeque<>();

        for (String token : tokens) {
            token = token.trim();

            // Пропускаем пустые токены
            if (token.isEmpty()) {
                continue;
            }

            // Если токен - число
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            }
            // Если токен - оператор
            else if (isOperator(token)) {
                // Проверяем, достаточно ли операндов в стеке
                if (stack.size() < 2) {
                    throw new IllegalArgumentException(
                            "Недостаточно операндов для оператора '" + token + "'"
                    );
                }

                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperation(token, a, b);
                stack.push(result);
            }
            // Если токен - унарная операция или функция
            else if (isUnaryOperator(token)) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Недостаточно операндов для унарного оператора '" + token + "'"
                    );
                }

                double a = stack.pop();
                double result = applyUnaryOperation(token, a);
                stack.push(result);
            }
            else {
                throw new IllegalArgumentException("Неизвестный токен: '" + token + "'");
            }
        }

        // В стеке должен остаться ровно один элемент - результат
        if (stack.size() != 1) {
            throw new IllegalArgumentException(
                    "Некорректное выражение. В стеке осталось " + stack.size() + " элементов"
            );
        }

        return stack.pop();
    }

    /**
     * Проверяет, является ли токен числом
     */
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Проверяет, является ли токен бинарным оператором
     */
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") ||
                token.equals("^") || token.equals("%");
    }


    private static boolean isUnaryOperator(String token) {
        return token.equals("sin") || token.equals("cos") || token.equals("tan") ||
                token.equals("sqrt") || token.equals("log") || token.equals("ln") ||
                token.equals("abs") || token.equals("neg") || token.equals("!");
    }

    /**
     * Применяет бинарную операцию
     */
    private static double applyOperation(String operator, double a, double b) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return a / b;
            case "^":
                return Math.pow(a, b);
            case "%":
                return a % b;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }

    /**
     * Применяет унарную операцию или функцию
     */
    private static double applyUnaryOperation(String operator, double a) {
        switch (operator) {
            case "sin":
                return Math.sin(Math.toRadians(a)); // градусы
            case "cos":
                return Math.cos(Math.toRadians(a));
            case "tan":
                return Math.tan(Math.toRadians(a));
            case "sqrt":
                if (a < 0) {
                    throw new ArithmeticException("Корень из отрицательного числа");
                }
                return Math.sqrt(a);
            case "log":
                if (a <= 0) {
                    throw new ArithmeticException("Логарифм неположительного числа");
                }
                return Math.log10(a);
            case "ln":
                if (a <= 0) {
                    throw new ArithmeticException("Натуральный логарифм неположительного числа");
                }
                return Math.log(a);
            case "abs":
                return Math.abs(a);
            case "neg":
                return -a;
            case "!":
                if (a < 0 || a != Math.floor(a)) {
                    throw new ArithmeticException("Факториал определен только для неотрицательных целых чисел");
                }
                return factorial((int) a);
            default:
                throw new IllegalArgumentException("Неизвестный унарный оператор: " + operator);
        }
    }

    /**
     * Вычисляет факториал
     */
    private static double factorial(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;

        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}