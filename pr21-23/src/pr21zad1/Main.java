package pr21zad1;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Пример 1: Со строками
        String[] fruits = {"Apple", "Banana", "Orange"};
        List<String> fruitList = ArrayConverter.convertArrayToList(fruits);
        System.out.println("Фрукты: " + fruitList);

        // Пример 2: С числами (объекты Integer)
        Integer[] numbers = {1, 2, 3, 4, 5};
        List<Integer> numberList = ArrayConverter.convertArrayToList(numbers);
        System.out.println("Числа: " + numberList);

        // Пример 3: С примитивами int
        int[] scores = {95, 87, 91, 78};
        List<Integer> scoreList = ArrayConverter.convertArrayToList(scores);
        System.out.println("Оценки: " + scoreList);

        // Пример 4: С double
        double[] prices = {19.99, 29.99, 9.99};
        List<Double> priceList = ArrayConverter.convertArrayToList(prices);
        System.out.println("Цены: " + priceList);

    }
}