package pr20zad1_3;

import java.util.List;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        System.out.println("ДЕМОНСТРАЦИЯ ОБОБЩЕННОГО КЛАССА TRIPLE\n");

        // Пример 1: String, Dog, Integer
        System.out.println("Пример 1: String, Dog, Integer");
        Triple<String, Dog, Integer> triple1 = new Triple<>(
                "Hello World",
                new Dog("Бобик", 3, "Овчарка"),
                42
        );

        triple1.printClassNames();
        triple1.printAnimalInfo();
        triple1.compareWith("Hello Java");
        System.out.println("Полный объект: " + triple1);
        System.out.println();

        // Пример 2: Integer, Cat, Double
        System.out.println("Пример 2: Integer, Cat, Double");
        Triple<Integer, Cat, Double> triple2 = new Triple<>(
                100,
                new Cat("Мурка", 2, "рыжий"),
                3.14
        );

        triple2.printClassNames();
        triple2.printAnimalInfo();
        triple2.compareWith(50);
        System.out.println("Полный объект: " + triple2);
        System.out.println();

        // Пример 3: Double, Dog, String
        System.out.println("Пример 3: Double, Dog, String");
        Triple<Double, Dog, String> triple3 = new Triple<>(
                99.99,
                new Dog("Шарик", 5, "Дворняжка"),
                "Произвольная строка"
        );

        triple3.printClassNames();
        triple3.printAnimalInfo();
        triple3.compareWith(100.0);
        System.out.println("Полный объект: " + triple3);
        System.out.println();

        // Пример 4: Использование классов-оберток
        System.out.println("Пример 4: Разные классы-обертки");
        Triple<Long, Cat, Boolean> triple4 = new Triple<>(
                123456789L,
                new Cat("Васька", 4, "черный"),
                true
        );

        triple4.printClassNames();
        System.out.println("Полный объект: " + triple4);
        System.out.println();

        // Демонстрация работы с коллекциями Triple
        System.out.println("РАБОТА С КОЛЛЕКЦИЯМИ");
        List<Triple<String, Animal, Integer>> triples = new ArrayList<>();
        triples.add(new Triple<>("Первый", new Dog("Рекс", 2, "Такса"), 1));
        triples.add(new Triple<>("Второй", new Cat("Барсик", 1, "белый"), 2));
        triples.add(new Triple<>("Третий", new Dog("Люси", 4, "Лабрадор"), 3));

        for (Triple<String, Animal, Integer> triple : triples) {
            System.out.println(triple);
            triple.printClassNames();
            System.out.println("---");
        }

        // Демонстрация методов доступа
        System.out.println("МЕТОДЫ ДОСТУПА К ДАННЫМ");
        Triple<String, Dog, List<String>> complexTriple = new Triple<>(
                "Сложный объект",
                new Dog("Чарли", 6, "Пудель"),
                List.of("элемент1", "элемент2", "элемент3")
        );

        System.out.println("First: " + complexTriple.getFirst());
        System.out.println("Second: " + complexTriple.getSecond());
        System.out.println("Third: " + complexTriple.getThird());
    }
}