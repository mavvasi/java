package zad2;
import java.util.Scanner;

public class zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        int size;
        do {
            System.out.print("Введите размер массива: ");
            size = scanner.nextInt();
        } while (size <= 0);

        // Ввод элементов массива
        int[] numbers = new int[size];
        System.out.println("Введите " + size + " элементов массива:");

        int i = 0;
        do {
            numbers[i] = scanner.nextInt();
            i++;
        } while (i < size);

        // Вычисление суммы, максимума и минимума
        int sum = 0;
        int max = numbers[0];
        int min = numbers[0];

        int j = 0;
        while (j < numbers.length) {
            sum += numbers[j];

            if (numbers[j] > max) {
                max = numbers[j];
            }

            if (numbers[j] < min) {
                min = numbers[j];
            }

            j++;
        }

        // Вывод результатов
        System.out.println("\nРезультаты:");
        System.out.print("Массив: ");

        int k = 0;
        do {
            System.out.print(numbers[k] + " ");
            k++;
        } while (k < numbers.length);

        System.out.println("\nСумма элементов: " + sum);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Минимальный элемент: " + min);

        scanner.close();
    }
}