package pr27zad123;

import java.util.LinkedList;

class HashEntry {
    String key;
    String value;

    public HashEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class hashtab {
    private LinkedList<HashEntry>[] table;
    private int size;

    // hashtabInit()
    public hashtab(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // hashtabHash()
    private int hashtabHash(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    // hashtabAdd()
    public void hashtabAdd(String key, String value) {
        int index = hashtabHash(key);
        for (HashEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Обновляем значение, если ключ уже существует
                return;
            }
        }
        table[index].add(new HashEntry(key, value));
    }

    // hashtabLookup()
    public String hashtabLookup(String key) {
        int index = hashtabHash(key);
        for (HashEntry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    // hashtabDelete()
    public void hashtabDelete(String key) {
        int index = hashtabHash(key);
        table[index].removeIf(entry -> entry.key.equals(key));
    }

    // Метод для вывода всей таблицы (для тестирования)
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            for (HashEntry entry : table[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    // Задание 2 и 3: тестирование
    public static void main(String[] args) {
        hashtab dict = new hashtab(10);

        // Добавляем 10 элементов
        dict.hashtabAdd("apple", "fruit");
        dict.hashtabAdd("carrot", "vegetable");
        dict.hashtabAdd("dog", "animal");
        dict.hashtabAdd("sun", "star");
        dict.hashtabAdd("java", "language");
        dict.hashtabAdd("moon", "satellite");
        dict.hashtabAdd("water", "liquid");
        dict.hashtabAdd("fire", "element");
        dict.hashtabAdd("earth", "planet");
        dict.hashtabAdd("air", "gas");

        System.out.println("Хеш-таблица после добавления");
        dict.display();

        // Поиск элемента
        System.out.println("\nПоиск ключа 'java': " + dict.hashtabLookup("java"));
        System.out.println("Поиск ключа 'unknown': " + dict.hashtabLookup("unknown"));

        // Удаление элемента
        dict.hashtabDelete("dog");
        System.out.println("\n=== После удаления 'dog' ===");
        dict.display();
    }
}