package pr22zad1;

import java.util.Stack;
public class SimpleRPNCalculator {

    public static double calculate(String rpnExpression) {
        String[] tokens = rpnExpression.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(token, a, b));
            }
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double applyOperator(String operator, double a, double b) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }

    public static void main(String[] args) {
        // Примеры использования
        String[] expressions = {
                "3 4 +",           // 7
                "5 1 2 + 4 * +",   // 17
                "10 2 * 3 +",      // 23
                "15 7 - 3 /"       // 2.666...
        };

        for (String expr : expressions) {
            System.out.printf("%s = %.2f%n", expr, calculate(expr));
        }
    }
}