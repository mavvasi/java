package zad2pr2;

public class Ball {
    private double x = 0.0;
    private double y = 0.0;

    // Конструктор с параметрами
    public Ball(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Конструктор по умолчанию
    public Ball() {
        // x и y уже инициализированы значениями по умолчанию (0.0)
    }

    // Геттер для x
    public double getX() {
        return x;
    }

    // Сеттер для x
    public void setX(double x) {
        this.x = x;
    }

    // Геттер для y
    public double getY() {
        return y;
    }

    // Сеттер для y
    public void setY(double y) {
        this.y = y;
    }

    // Установка обеих координат одновременно
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Перемещение мяча на заданное смещение
    public void move(double xDisp, double yDisp) {
        this.x += xDisp;
        this.y += yDisp;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Ball[(" + x + ", " + y + ")]";
    }
}