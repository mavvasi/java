package pr28zad2;

import java.util.*;

public class Task2 {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петров", "Петр");
        map.put("Сидоров", "Иван");
        map.put("Кузнецов", "Алексей");
        map.put("Смирнов", "Петр");
        map.put("Попов", "Сергей");
        map.put("Васильев", "Иван");
        map.put("Михайлов", "Алексей");
        map.put("Федоров", "Сергей");
        map.put("Новиков", "Андрей");
        return map;
    }

    public static int getSameFirstNameCount(HashMap<String, String> map) {
        HashMap<String, Integer> nameCount = new HashMap<>();
        for (String name : map.values()) {
            nameCount.put(name, nameCount.getOrDefault(name, 0) + 1);
        }
        int count = 0;
        for (int c : nameCount.values()) {
            if (c > 1) count++;
        }
        return count;
    }

    public static int getSameLastNameCount(HashMap<String, String> map) {
        // В данном случае ключи уникальны, поэтому одинаковых фамилий быть не может
        // Но если предположить, что ключ — это фамилия, то она уникальна
        // Поэтому метод всегда вернет 0
        return 0;
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println("Карта: " + map);
        System.out.println("Количество одинаковых имен: " + getSameFirstNameCount(map));
        System.out.println("Количество одинаковых фамилий: " + getSameLastNameCount(map));
    }
}
