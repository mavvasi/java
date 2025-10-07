package zad1pr6;

import java.util.ArrayList;
import java.util.List;

public class NameableTester {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ИНТЕРФЕЙСА NAMEABLE ===\n");

        // Создание списка различных объектов, реализующих интерфейс Nameable
        List<Nameable> nameableObjects = new ArrayList<>();

        // Добавление объектов разных типов
        nameableObjects.add(new Planet("Земля", 5.97e24, 6371));
        nameableObjects.add(new Planet("Марс", 6.39e23, 3389));
        nameableObjects.add(new Car("Model S", "Tesla", 2023, 0.0)); // электромобиль
        nameableObjects.add(new Car("Camry", "Toyota", 2022, 2.5));
        nameableObjects.add(new Animal("Барсик", "Кот", 3, "дом"));
        nameableObjects.add(new Animal("Шарик", "Собака", 5, "дом"));
        nameableObjects.add(new Book("Война и мир", "Лев Толстой", 1869, "роман"));
        nameableObjects.add(new Book("1984", "Джордж Оруэлл", 1949, "антиутопия"));

        // Демонстрация 1: Вывод всех объектов через интерфейс Nameable
        System.out.println("1. ВСЕ ОБЪЕКТЫ:");
        System.out.println("=" .repeat(80));
        for (Nameable obj : nameableObjects) {
            System.out.println(obj.toString());
        }

        // Демонстрация 2: Использование только методов интерфейса Nameable
        System.out.println("\n2. ИМЕНА ОБЪЕКТОВ (через интерфейс Nameable):");
        System.out.println("=" .repeat(50));
        for (Nameable obj : nameableObjects) {
            System.out.println("Имя: " + obj.getName());
        }

        // Демонстрация 3: Группировка по типам
        System.out.println("\n3. ГРУППИРОВКА ПО ТИПАМ ОБЪЕКТОВ:");
        printGroupedByNameable(nameableObjects);

        // Демонстрация 4: Поиск по имени
        System.out.println("\n4. ПОИСК ОБЪЕКТОВ ПО ИМЕНИ:");
        searchByName(nameableObjects, "Земля");
        searchByName(nameableObjects, "Барсик");
        searchByName(nameableObjects, "Несуществующий");

        // Демонстрация 5: Использование полиморфизма
        System.out.println("\n5. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");
        demonstratePolymorphism();
    }

    // Метод для группировки объектов по типам
    public static void printGroupedByNameable(List<Nameable> objects) {
        List<Planet> planets = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        List<Book> books = new ArrayList<>();


        for (Nameable obj : objects) {
            if (obj instanceof Planet) {
                planets.add((Planet) obj);
            } else if (obj instanceof Car) {
                cars.add((Car) obj);
            } else if (obj instanceof Animal) {
                animals.add((Animal) obj);
            } else if (obj instanceof Book) {
                books.add((Book) obj);
            }
        }

        System.out.println("Планеты (" + planets.size() + "):");
        planets.forEach(p -> System.out.println("  - " + p.getName()));

        System.out.println("Автомобили (" + cars.size() + "):");
        cars.forEach(c -> System.out.println("  - " + c.getName()));

        System.out.println("Животные (" + animals.size() + "):");
        animals.forEach(a -> System.out.println("  - " + a.getName()));

        System.out.println("Книги (" + books.size() + "):");
        books.forEach(b -> System.out.println("  - " + b.getName()));

    }

    // Метод для поиска объектов по имени
    public static void searchByName(List<Nameable> objects, String name) {
        System.out.println("\nПоиск: '" + name + "'");
        boolean found = false;

        for (Nameable obj : objects) {
            if (obj.getName().equalsIgnoreCase(name)) {
                System.out.println("Найден: " + obj.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Объект с именем '" + name + "' не найден");
        }
    }

    // Метод для демонстрации полиморфизма
    public static void demonstratePolymorphism() {
        System.out.println("Создание объектов через интерфейс Nameable:");

        Nameable planet = new Planet("Юпитер", 1.9e27, 69911);
        Nameable car = new Car("Civic", "Honda", 2023, 1.5);
        Nameable animal = new Animal("Рекс", "Собака", 4, "дом");

        // Вызов метода getName() через интерфейс - полиморфизм во время выполнения
        Nameable[] items = {planet, car, animal};

        for (Nameable item : items) {
            System.out.println("Тип: " + item.getClass().getSimpleName() +
                    ", Имя: " + item.getName());
        }

        // Демонстрация работы с коллекциями через интерфейс
        System.out.println("\nРабота с коллекцией через интерфейс:");
        List<Nameable> collection = new ArrayList<>();
        collection.add(planet);
        collection.add(car);
        collection.add(animal);

        for (Nameable item : collection) {
            System.out.println("-> " + item.getName());
        }
    }
}
