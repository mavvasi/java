package zad1pr4;

public class Circle extends Shape {
    private double radius;

    // Конструктор
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть положительным числом");
        }
        this.radius = radius;
    }

    // Реализация абстрактных методов
    @Override
    public String getType() {
        return "Окружность";
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Геттер для радиуса
    public double getRadius() {
        return radius;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return String.format("Окружность [Радиус: %.2f, Площадь: %.2f, Длина окружности: %.2f]",
                radius, getArea(), getPerimeter());
    }
}
