package zad2pr3;

public class Main {
    public static void main(String[] args) {

        // Создание объекта Tester с массивом на 10 элементов
        Tester tester = new Tester(10);

        // Заполнение массива случайными окружностями
        System.out.println("1. СОЗДАНИЕ СЛУЧАЙНЫХ ОКРУЖНОСТЕЙ");
        tester.fillWithRandomCircles(6);
        tester.printAllCircles();

        // Поиск самой маленькой и самой большой окружности
        System.out.println("\n2. ПОИСК ЭКСТРЕМАЛЬНЫХ ОКРУЖНОСТЕЙ");
        Circle smallest = tester.findSmallestCircle();
        Circle largest = tester.findLargestCircle();

        System.out.println("Самая маленькая окружность:");
        System.out.println(smallest);
        System.out.println("\nСамая большая окружность:");
        System.out.println(largest);

        // Сортировка и вывод
        System.out.println("\n3. СОРТИРОВКА ПО РАДИУСУ (ВОЗРАСТАНИЕ)");
        tester.sortCirclesByRadius();
        tester.printAllCircles();

        // Добавление еще нескольких окружностей вручную
        System.out.println("\n4. ДОБАВЛЕНИЕ ОКРУЖНОСТЕЙ ВРУЧНУЮ");
        tester.addCircle(new Circle(new Point(5, 5), 8));
        tester.addCircle(new Circle(10, 15, 12));

        // Сортировка по площади
        System.out.println("\n5. СОРТИРОВКА ПО ПЛОЩАДИ (УБЫВАНИЕ)");
        tester.sortCirclesByArea();
        tester.printAllCircles();

        // Вывод статистики
        tester.printStatistics();

        // Демонстрация работы с точками
        System.out.println("\n6. ДЕМОНСТРАЦИЯ РАБОТЫ С ТОЧКАМИ");
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        System.out.printf("Расстояние между %s и %s: %.2f\n", p1, p2, p1.distanceTo(p2));

        Circle c1 = new Circle(p1, 5);
        Circle c2 = new Circle(p2, 3);
        System.out.printf("Окружности пересекаются: %s\n", c1.intersects(c2));
    }
}
