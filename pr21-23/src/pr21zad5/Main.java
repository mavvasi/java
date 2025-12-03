package pr21zad5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Пример 1: Создание Solution объекта ===");
        Solution<String, Integer, Double> solution =
                new Solution<>("Test", 123, 45.67);
        System.out.println(solution);
        System.out.println("GenericField: " + solution.getGenericField());
        System.out.println("KeyField: " + solution.getKeyField());
        System.out.println("ValueField: " + solution.getValueField());

        System.out.println("\n=== Пример 2: Использование newArrayList ===");
        List<String> stringList = Solution.newArrayList("Яблоко", "Банан", "Апельсин");
        System.out.println("ArrayList строк: " + stringList);

        List<Integer> intList = Solution.newArrayList(1, 2, 3, 4, 5);
        System.out.println("ArrayList чисел: " + intList);

        // Пустой список
        List<Double> emptyList = Solution.newArrayList();
        System.out.println("Пустой ArrayList: " + emptyList);

        System.out.println("\n=== Пример 3: Использование newHashSet ===");
        Set<String> stringSet = Solution.newHashSet("Красный", "Зеленый", "Синий", "Красный");
        System.out.println("HashSet цветов (дубликаты удалены): " + stringSet);

        Set<Integer> numberSet = Solution.newHashSet(10, 20, 30, 40, 50);
        System.out.println("HashSet чисел: " + numberSet);

        System.out.println("\n=== Пример 4: Использование newHashMap ===");
        // Способ 1: с использованием varargs
        Map<String, Integer> ageMap = Solution.newHashMap(
                "Анна", 25,
                "Борис", 30,
                "Виктор", 35
        );
        System.out.println("HashMap возрастов: " + ageMap);

        // Способ 2: с использованием класса Pair
        Map<String, Double> priceMap = Solution.newHashMap(
                new Pair<>("Хлеб", 45.50),
                new Pair<>("Молоко", 85.00),
                new Pair<>("Сыр", 320.75)
        );
        System.out.println("HashMap цен: " + priceMap);

        // Способ 3: из массивов ключей и значений
        String[] countries = {"Россия", "США", "Китай"};
        String[] capitals = {"Москва", "Вашингтон", "Пекин"};
        Map<String, String> capitalMap = Solution.newHashMap(countries, capitals);
        System.out.println("HashMap столиц: " + capitalMap);

        System.out.println("\n=== Пример 5: Комплексный пример ===");
        // Создаем Solution с различными типами
        Solution<List<String>, Map<String, Integer>, Set<Double>> complexSolution =
                new Solution<>(
                        Arrays.asList("A", "B", "C"),
                        new HashMap<>(),
                        new HashSet<>(Arrays.asList(1.1, 2.2, 3.3))
                );

        // Используем методы для работы с коллекциями
        List<String> newList = Solution.newArrayList("X", "Y", "Z");
        complexSolution.setGenericField(newList);

        System.out.println("Обновленный Solution: " + complexSolution);

        System.out.println("\n=== Пример 6: Обработка ошибок ===");
        try {
            // Нечетное количество аргументов - ошибка
            Map<String, Integer> errorMap = Solution.newHashMap("Один", 1, "Два");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

    }
}