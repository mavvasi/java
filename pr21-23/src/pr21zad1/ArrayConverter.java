package pr21zad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayConverter {

    // Универсальный метод для любых объектов
    public static <T> List<T> convertArrayToList(T[] array) {
        if (array == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(array));
    }

    // Для примитивных типов нужны отдельные методы

    // Для int[]
    public static List<Integer> convertArrayToList(int[] array) {
        if (array == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>(array.length);
        for (int value : array) {
            list.add(value);
        }
        return list;
    }

    // Для double[]
    public static List<Double> convertArrayToList(double[] array) {
        if (array == null) {
            return new ArrayList<>();
        }
        List<Double> list = new ArrayList<>(array.length);
        for (double value : array) {
            list.add(value);
        }
        return list;
    }

}