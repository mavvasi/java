package zad1pr5;

import java.awt.Color;
import java.awt.Graphics;

// Абстрактный класс фигуры
public abstract class Shape {
    protected Color color;
    protected int x;
    protected int y;

    // Конструктор
    public Shape(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    // Абстрактные методы
    public abstract void draw(Graphics g);
    public abstract String getType();

    // Геттеры
    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("%s [x=%d, y=%d, color=%s]",
                getType(), x, y, color.toString());
    }
}