package zad1pr5;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ShapeWindow extends JFrame {
    private Shape[] shapes;
    private Random random;

    public ShapeWindow() {
        // Настройка окна
        setTitle("20 Random Shapes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        random = new Random();
        shapes = new Shape[20];

        // Создание 20 случайных фигур
        createRandomShapes();
    }

    private void createRandomShapes() {
        for (int i = 0; i < shapes.length; i++) {
            // Случайный цвет
            Color color = new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            );

            // Случайная позиция (с отступами от краев)
            int x = 50 + random.nextInt(600);
            int y = 50 + random.nextInt(400);

            // Случайный выбор типа фигуры
            int shapeType = random.nextInt(4);

            switch (shapeType) {
                case 0: // Circle
                    int radius = 20 + random.nextInt(50);
                    shapes[i] = new Circle(color, x, y, radius);
                    break;

                case 1: // Rectangle
                    int width = 30 + random.nextInt(100);
                    int height = 30 + random.nextInt(100);
                    shapes[i] = new Rectangle(color, x, y, width, height);
                    break;

                case 2: // Square
                    int size = 30 + random.nextInt(80);
                    shapes[i] = new Square(color, x, y, size);
                    break;

            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Очистка фона
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Отрисовка всех фигур
        for (Shape shape : shapes) {
            if (shape != null) {
                shape.draw(g);
            }
        }

        // Вывод информации
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString("20 Random Shapes - Close window to exit", 20, 40);
    }

    public static void main(String[] args) {
        // Запуск приложения в Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            ShapeWindow window = new ShapeWindow();
            window.setVisible(true);
        });
    }
}