package pr28zad1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        // Создаем HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("orange");
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("grape");
        hashSet.add("kiwi");

        System.out.println("HashSet: " + hashSet);

        // Преобразуем HashSet в TreeSet (автоматическая сортировка)
        TreeSet<String> treeSet = new TreeSet<>(hashSet);

        System.out.println("TreeSet (отсортировано): " + treeSet);
    }
}