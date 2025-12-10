package pr27zad4;

import java.util.TreeSet;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // TreeSet автоматически сортирует элементы (приоритетная очередь)
        TreeSet<Integer> priorityQueue = new TreeSet<>();

        // Добавляем 10 элементов
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(50);
        priorityQueue.add(20);
        priorityQueue.add(40);
        priorityQueue.add(60);
        priorityQueue.add(5);
        priorityQueue.add(25);
        priorityQueue.add(35);
        priorityQueue.add(45);

        System.out.println("Очередь с приоритетом (TreeSet): " + priorityQueue);

        // Извлекаем и выводим несколько элементов (наименьшие сначала)
        System.out.println("\nИзвлечение элементов:");
        System.out.println("Извлечено: " + priorityQueue.pollFirst()); // 5
        System.out.println("Извлечено: " + priorityQueue.pollFirst()); // 10
        System.out.println("Извлечено: " + priorityQueue.pollFirst()); // 20

        System.out.println("Очередь после извлечения: " + priorityQueue);
    }
}