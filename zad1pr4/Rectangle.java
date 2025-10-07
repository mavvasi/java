package zad1pr4;

public class Rectangle extends Shape {
    private double width;
    private double height;

    // Конструктор
    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами");
        }
        this.width = width;
        this.height = height;
    }

    // Реализация абстрактных методов
    @Override
    public String getType() {
        return "Прямоугольник";
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Геттеры
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Переопределение toString
    @Override
    public String toString() {
        return String.format("Прямоугольник [Ширина: %.2f, Высота: %.2f, Площадь: %.2f, Периметр: %.2f]",
                width, height, getArea(), getPerimeter());
    }
}