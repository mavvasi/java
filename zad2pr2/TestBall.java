package zad2pr2;

public class TestBall {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ КЛАССА BALL ===\n");

        // Тестирование конструктора по умолчанию
        Ball ball1 = new Ball();
        System.out.println("Мяч 1 (конструктор по умолчанию):");
        System.out.println("Начальная позиция: " + ball1.toString());

        // Тестирование конструктора с параметрами
        Ball ball2 = new Ball(2.5, 3.7);
        System.out.println("\nМяч 2 (конструктор с параметрами):");
        System.out.println("Начальная позиция: " + ball2.toString());

        // Тестирование геттеров и сеттеров
        System.out.println("\n=== ТЕСТИРОВАНИЕ ГЕТТЕРОВ И СЕТТЕРОВ ===");
        System.out.println("Мяч 2 - X: " + ball2.getX() + ", Y: " + ball2.getY());

        ball2.setX(5.0);
        ball2.setY(1.2);
        System.out.println("После setX(5.0) и setY(1.2): " + ball2.toString());

        // Тестирование метода setXY
        System.out.println("\n=== ТЕСТИРОВАНИЕ SETXY ===");
        ball1.setXY(10.0, 15.5);
        System.out.println("Мяч 1 после setXY(10.0, 15.5): " + ball1.toString());

        // Тестирование метода move
        System.out.println("\n=== ТЕСТИРОВАНИЕ MOVE ===");
        System.out.println("Мяч 2 до перемещения: " + ball2.toString());
        ball2.move(3.0, -2.0);
        System.out.println("После move(3.0, -2.0): " + ball2.toString());

        // Демонстрация последовательности перемещений
        System.out.println("\n=== ДЕМОНСТРАЦИЯ ПОСЛЕДОВАТЕЛЬНОСТИ ПЕРЕМЕЩЕНИЙ ===");
        Ball movingBall = new Ball(0.0, 0.0);
        System.out.println("Начальная позиция: " + movingBall.toString());

        movingBall.move(2.0, 3.0);
        System.out.println("После move(2.0, 3.0): " + movingBall.toString());

        movingBall.move(-1.0, 1.5);
        System.out.println("После move(-1.0, 1.5): " + movingBall.toString());

        movingBall.move(0.5, -2.0);
        System.out.println("После move(0.5, -2.0): " + movingBall.toString());

    }
}