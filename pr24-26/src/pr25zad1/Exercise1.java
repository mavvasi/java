package pr25zad1;

import java.util.Stack;

public class Exercise1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Исходный массив:");
        printArray(array);

        invertArrayUsingStack(array);

        System.out.println("Инвертированный массив:");
        printArray(array);
    }

    public static void invertArrayUsingStack(int[] array) {
        Stack<Integer> stack = new Stack<>();

        // Помещаем все элементы массива в стек
        for (int element : array) {
            stack.push(element);
        }

        // Извлекаем элементы из стека (они будут в обратном порядке)
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

