package zad2pr3;

import java.util.Random;

public class Circle {
    private Point center;
    private double radius;
    private double circumference;

    // Конструкторы
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        this.circumference = 2 * Math.PI * radius;
    }

    public Circle(double x, double y, double radius) {
        this(new Point(x, y), radius);
    }

    // Конструктор со случайной генерацией
    public Circle() {
        Random random = new Random();
        this.center = new Point(random.nextDouble() * 100, random.nextDouble() * 100);
        this.radius = 1 + random.nextDouble() * 19; // радиус от 1 до 20
        this.circumference = 2 * Math.PI * this.radius;
    }

    // Геттеры
    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Метод для проверки пересечения с другой окружностью
    public boolean intersects(Circle other) {
        double distance = center.distanceTo(other.center);
        return distance <= (this.radius + other.radius);
    }

    @Override
    public String toString() {
        return String.format("Circle{center=%s, radius=%.2f, circumference=%.2f, area=%.2f}",
                center, radius, circumference, getArea());
    }
}
