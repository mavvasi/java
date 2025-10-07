package zad1pr4;

public class ShapeTester {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА В JAVA ===\n");

        // Создание массива фигур (используем родительский тип Shape)
        Shape[] shapes = new Shape[6];

        // Заполнение массива разными фигурами
        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Square(3.0);
        shapes[3] = new Circle(2.5);
        shapes[4] = new Rectangle(5.0, 5.0);
        shapes[5] = new Square(4.0);

        // Демонстрация вызова методов через родительскую ссылку
        System.out.println("1. ВЫВОД ИНФОРМАЦИИ О ВСЕХ ФИГУРАХ:");
        System.out.println("=" .repeat(60));

        for (int i = 0; i < shapes.length; i++) {
            System.out.println((i + 1) + ". " + shapes[i].toString());
        }

        // Демонстрация отдельных методов через родительскую ссылку
        System.out.println("\n2. ВЫЗОВ МЕТОДОВ ЧЕРЕЗ РОДИТЕЛЬСКУЮ ССЫЛКУ:");
        System.out.println("=" .repeat(60));

        for (Shape shape : shapes) {
            System.out.println("Тип фигуры: " + shape.getType());
            System.out.println("Площадь: " + String.format("%.2f", shape.getArea()));
            System.out.println("Периметр: " + String.format("%.2f", shape.getPerimeter()));
            System.out.println("-".repeat(40));
        }

        // Статистика по всем фигурам
        System.out.println("\n3. СТАТИСТИКА ПО ВСЕМ ФИГУРАМ:");
        System.out.println("=" .repeat(60));
        printStatistics(shapes);

        // Демонстрация полиморфизма с конкретными типами
        System.out.println("\n4. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");
        System.out.println("=" .repeat(60));
        demonstratePolymorphism();
    }

    // Метод для вывода статистики
    public static void printStatistics(Shape[] shapes) {
        double totalArea = 0;
        double totalPerimeter = 0;

        for (Shape shape : shapes) {
            totalArea += shape.getArea();
            totalPerimeter += shape.getPerimeter();
        }

        System.out.printf("Общее количество фигур: %d\n", shapes.length);
        System.out.printf("Суммарная площадь всех фигур: %.2f\n", totalArea);
        System.out.printf("Суммарный периметр всех фигур: %.2f\n", totalPerimeter);
        System.out.printf("Средняя площадь: %.2f\n", totalArea / shapes.length);
        System.out.printf("Средний периметр: %.2f\n", totalPerimeter / shapes.length);
    }

    // Метод для демонстрации полиморфизма
    public static void demonstratePolymorphism() {
        Shape shape1 = new Circle(3.0);
        Shape shape2 = new Rectangle(4.0, 5.0);
        Shape shape3 = new Square(6.0);

        // Вызов методов через родительскую ссылку
        // Во время выполнения Java определяет, какой именно метод вызывать
        System.out.println("Shape 1: " + shape1.getType() +
                ", Area: " + String.format("%.2f", shape1.getArea()));
        System.out.println("Shape 2: " + shape2.getType() +
                ", Area: " + String.format("%.2f", shape2.getArea()));
        System.out.println("Shape 3: " + shape3.getType() +
                ", Area: " + String.format("%.2f", shape3.getArea()));

        // Демонстрация работы оператора instanceof
        System.out.println("\nПроверка типов с помощью instanceof:");
        checkShapeType(shape1);
        checkShapeType(shape2);
        checkShapeType(shape3);
    }

    // Метод для проверки типа фигуры
    public static void checkShapeType(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("Это окружность с радиусом: " + ((Circle) shape).getRadius());
        } else if (shape instanceof Square) {
            System.out.println("Это квадрат со стороной: " + ((Square) shape).getSide());
        } else if (shape instanceof Rectangle) {
            Rectangle rect = (Rectangle) shape;
            System.out.println("Это прямоугольник " + rect.getWidth() + "x" + rect.getHeight());
        }
    }
}
