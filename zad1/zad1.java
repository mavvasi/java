package zad1;
import java.util.Scanner;

public class zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите количество элементов массива: ");
        int size = scanner.nextInt();

        // Создание массива
        int[] numbers = new int[size];

        // Ввод элементов массива
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Подсчет суммы элементов массива
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        // Вычисление среднего арифметического
        double average = (double) sum / numbers.length;

        // Вывод результатов
        System.out.println("\nРезультаты:");
        System.out.print("Массив: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("\nСумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);

        scanner.close();
    }
}