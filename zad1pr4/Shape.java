package zad1pr4;

// Абстрактный класс Shape (Фигура)
public abstract class Shape {
    // Абстрактные методы, которые должны быть реализованы в дочерних классах
    public abstract String getType();
    public abstract double getArea();
    public abstract double getPerimeter();

    // Реализованный метод toString в родительском классе
    @Override
    public String toString() {
        return String.format("Фигура: %s, Площадь: %.2f, Периметр: %.2f",
                getType(), getArea(), getPerimeter());
    }
}
