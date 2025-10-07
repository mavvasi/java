package zad1pr5;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
    private int radius;

    public Circle(Color color, int x, int y, int radius) {
        super(color, x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

        // Контур для лучшей видимости
        g.setColor(Color.BLACK);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public String getType() {
        return "Circle";
    }

    public int getRadius() {
        return radius;
    }
}