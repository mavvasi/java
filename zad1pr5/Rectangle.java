package zad1pr5;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Color color, int x, int y, int width, int height) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);

        // Контур для лучшей видимости
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
