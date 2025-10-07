package zad1pr4;

public class Square extends Shape {
    private double side;

    // Конструктор
    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительным числом");
        }
        this.side = side;
    }

    // Реализация абстрактных методов
    @Override
    public String getType() {
        return "Квадрат";
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    // Геттер для стороны
    public double getSide() {
        return side;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return String.format("Квадрат [Сторона: %.2f, Площадь: %.2f, Периметр: %.2f]",
                side, getArea(), getPerimeter());
    }
}
