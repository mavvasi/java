package zad2pr3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Tester {
    private Circle[] circles;
    private int count;

    // Конструктор
    public Tester(int capacity) {
        circles = new Circle[capacity];
        count = 0;
    }

    // Добавление окружности
    public void addCircle(Circle circle) {
        if (count < circles.length) {
            circles[count] = circle;
            count++;
        } else {
            System.out.println("Массив переполнен!");
        }
    }

    // Заполнение массива случайными окружностями
    public void fillWithRandomCircles(int numberOfCircles) {
        if (numberOfCircles > circles.length) {
            System.out.println("Запрошено больше окружностей, чем вмещает массив!");
            return;
        }

        for (int i = 0; i < numberOfCircles; i++) {
            circles[i] = new Circle();
            count++;
        }
    }

    // Поиск самой маленькой окружности (по радиусу)
    public Circle findSmallestCircle() {
        if (count == 0) return null;

        Circle smallest = circles[0];
        for (int i = 1; i < count; i++) {
            if (circles[i].getRadius() < smallest.getRadius()) {
                smallest = circles[i];
            }
        }
        return smallest;
    }

    // Поиск самой большой окружности (по радиусу)
    public Circle findLargestCircle() {
        if (count == 0) return null;

        Circle largest = circles[0];
        for (int i = 1; i < count; i++) {
            if (circles[i].getRadius() > largest.getRadius()) {
                largest = circles[i];
            }
        }
        return largest;
    }

    // Сортировка окружностей по радиусу (по возрастанию)
    public void sortCirclesByRadius() {
        Arrays.sort(circles, 0, count, new Comparator<Circle>() {
            @Override
            public int compare(Circle c1, Circle c2) {
                return Double.compare(c1.getRadius(), c2.getRadius());
            }
        });
    }

    // Сортировка окружностей по площади (по убыванию)
    public void sortCirclesByArea() {
        Arrays.sort(circles, 0, count, new Comparator<Circle>() {
            @Override
            public int compare(Circle c1, Circle c2) {
                return Double.compare(c2.getArea(), c1.getArea());
            }
        });
    }

    // Вывод всех окружностей
    public void printAllCircles() {
        System.out.println("Список всех окружностей (" + count + " шт.):");
        System.out.println("-".repeat(80));
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + circles[i]);
        }
        System.out.println("-".repeat(80));
    }

    // Получение количества элементов
    public int getCount() {
        return count;
    }

    // Получение общей информации
    public void printStatistics() {
        if (count == 0) {
            System.out.println("Массив пуст!");
            return;
        }

        double totalArea = 0;
        double totalCircumference = 0;

        for (int i = 0; i < count; i++) {
            totalArea += circles[i].getArea();
            totalCircumference += circles[i].getCircumference();
        }

        System.out.println("\nСТАТИСТИКА:");
        System.out.printf("Количество окружностей: %d\n", count);
        System.out.printf("Общая площадь: %.2f\n", totalArea);
        System.out.printf("Общая длина окружностей: %.2f\n", totalCircumference);
        System.out.printf("Средний радиус: %.2f\n", totalArea / count / Math.PI);
    }
}