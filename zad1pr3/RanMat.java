package zad1pr3;

import java.util.Arrays;
import java.util.Random;

public class RanMat {
    public static void main(String[] args) {
        System.out.println("=== ГЕНЕРАЦИЯ МАССИВА СЛУЧАЙНЫХ ЧИСЕЛ ===\n");

        // Размер массива
        int size = 8;

        // ПОДХОД 1: Использование Math.random()
        System.out.println("ПОДХОД 1: Math.random()");
        System.out.println("=========================");

        double[] array1 = new double[size];

        // Заполнение массива с помощью Math.random()
        for (int i = 0; i < size; i++) {
            array1[i] = Math.random() * 100; // числа от 0 до 100
        }

        // Вывод исходного массива
        System.out.println("Исходный массив:");
        printArray(array1);

        // Сортировка массива
        Arrays.sort(array1);

        // Вывод отсортированного массива
        System.out.println("Отсортированный массив:");
        printArray(array1);

        // ПОДХОД 2: Использование класса Random
        System.out.println("\nПОДХОД 2: Класс Random");
        System.out.println("======================");

        double[] array2 = new double[size];
        Random random = new Random();

        // Заполнение массива с помощью класса Random
        for (int i = 0; i < size; i++) {
            array2[i] = random.nextDouble() * 100; // числа от 0 до 100
        }

        // Вывод исходного массива
        System.out.println("Исходный массива:");
        printArray(array2);

        // Сортировка массива
        Arrays.sort(array2);

        // Вывод отсортированного массива
        System.out.println("Отсортированный массив:");
        printArray(array2);
    }

    // Метод для красивого вывода массива
    public static void printArray(double[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.2f", array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}