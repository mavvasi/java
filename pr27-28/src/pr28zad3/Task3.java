package pr28zad3;

import java.util.LinkedList;

class DoubleHashEntry {
    double key;
    String value;

    public DoubleHashEntry(double key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class Task3 {
    private LinkedList<DoubleHashEntry>[] table;
    private int size;

    public Task3(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Хеш-функция для вещественных чисел (Sedgewick, 2001, с. 575)
    private int hash(double key) {
        // Приводим double к long и берем по модулю
        long bits = Double.doubleToLongBits(key);
        return (int) Math.abs(bits % size);
    }

    public void put(double key, String value) {
        int index = hash(key);
        for (DoubleHashEntry entry : table[index]) {
            if (entry.key == key) {
                entry.value = value; // Обновляем, если ключ уже есть
                return;
            }
        }
        table[index].add(new DoubleHashEntry(key, value));
    }

    public String get(double key) {
        int index = hash(key);
        for (DoubleHashEntry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(double key) {
        int index = hash(key);
        table[index].removeIf(entry -> entry.key == key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Bucket " + i + ": ");
            for (DoubleHashEntry entry : table[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Task3 hashTable = new Task3(10);

        hashTable.put(3.14, "Pi");
        hashTable.put(2.71, "Euler");
        hashTable.put(1.618, "Golden ratio");
        hashTable.put(0.577, "Euler–Mascheroni");
        hashTable.put(1.414, "√2");

        System.out.println("Хеш-таблица с вещественными ключами:");
        hashTable.display();

        System.out.println("\nПоиск 2.71: " + hashTable.get(2.71));
        System.out.println("Поиск 1.618: " + hashTable.get(1.618));

        hashTable.remove(1.618);
        System.out.println("\nПосле удаления 1.618:");
        hashTable.display();
    }
}