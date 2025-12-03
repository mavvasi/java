package pr22zad1;

public class RPNCalculatorTest {

    public static void main(String[] args) {
        System.out.println("=== Тестирование RPN калькулятора ===\n");

        // Тестовые выражения и ожидаемые результаты
        Object[][] testCases = {
                {"3 4 +", 7.0},
                {"5 1 2 + 4 * + 3 -", 14.0},
                {"2 3 ^", 8.0},
                {"10 3 /", 10.0/3.0},
                {"45 sin", Math.sin(Math.toRadians(45))},
                {"pi 2 *", Math.PI * 2},
                {"5 !", 120.0},
                {"4 sqrt", 2.0},
                {"100 log", 2.0},
                {"10 neg 5 +", -5.0},
                {"3 4 5 * +", 23.0},
                {"15 7 -", 8.0},
                {"1 2 + 3 * 4 -", 5.0},
                {"2 3 4 + *", 14.0},
                {"5 1 2 + 4 * + 3 - sqrt", Math.sqrt(14.0)},
                {"e ln", 1.0},
                {"-5 abs", 5.0},
                {"2 3 + 4 5 + *", 45.0},
        };

        int passed = 0;
        int failed = 0;
        double tolerance = 0.000001;

        for (Object[] testCase : testCases) {
            String expression = (String) testCase[0];
            double expected = (Double) testCase[1];

            try {
                double actual = RPNCalculator.evaluate(expression);
                boolean isCorrect = Math.abs(actual - expected) < tolerance;

                if (isCorrect) {
                    System.out.printf("✓ %-30s = %12.6f (ожидалось: %12.6f)%n",
                            expression, actual, expected);
                    passed++;
                } else {
                    System.out.printf("✗ %-30s = %12.6f (ожидалось: %12.6f) РАЗНИЦА!%n",
                            expression, actual, expected);
                    failed++;
                }
            } catch (Exception e) {
                System.out.printf("✗ %-30s → ОШИБКА: %s%n", expression, e.getMessage());
                failed++;
            }
        }

    }
}