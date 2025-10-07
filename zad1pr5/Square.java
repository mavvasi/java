package zad1pr5;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape {
    private int size;

    public Square(Color color, int x, int y, int size) {
        super(color, x, y);
        this.size = size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);

        // Контур для лучшей видимости
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }

    @Override
    public String getType() {
        return "Square";
    }

    public int getSize() {
        return size;
    }
}